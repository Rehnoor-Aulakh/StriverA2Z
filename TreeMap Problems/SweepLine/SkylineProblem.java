package SweepLine;
import java.util.*;

public class SkylineProblem {
    static class Pair implements Comparable<Pair>{
        public int x;
        public int height;
        public Pair(int x, int height) {
            this.x= x;
            this.height=height;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.x != o.x) {
                // ascending order of x
                return this.x-o.x;
            } else {
                // sort by height
                // since for the same start time, more height would be more negative, so ascending would work
                return this.height - o.height;
            }
        }
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        // We have to use List<Pair> because the x coordinates can be same, so treemap would overwrite that
        List<Pair> events = new ArrayList<>();
        for(int[] building: buildings) {
            events.add(new Pair(building[0], -building[2]));   //start
            events.add(new Pair(building[1], building[2]));  // end
        }
        // Sort events by X-coordinate with tie-breaker rules for identical X
        Collections.sort(events);
        List<List<Integer>> ans = new ArrayList<>();

        // Use a TreeMap to track active building heights: Height -> Count
        TreeMap<Integer, Integer> activeHeights = new TreeMap<>();
        // base ground level
        activeHeights.put(0,1);
        int prevMaxHeight = 0;

        for(Pair event: events) {
            int point = event.x;
            int height = event.height;

            if(height<0) {
                height = -height;
                // Add building height to active set
                activeHeights.put(height, activeHeights.getOrDefault(height, 0)+1);
            } else {
                // Remove building height from active set
                int count = activeHeights.get(height);
                if(count==1) {
                    activeHeights.remove(height);
                } else{
                    activeHeights.put(height, count-1);
                }
            }
            // Get current max height across all active buildings
            int currentMaxHeight = activeHeights.lastKey();

            // Record key point whenever the skyline height changes
            if(currentMaxHeight != prevMaxHeight) {
                ans.add(List.of(point, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(getSkyline(buildings));
    }
}
