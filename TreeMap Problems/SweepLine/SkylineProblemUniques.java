package SweepLine;
import java.util.*;

public class SkylineProblemUniques {
    // Approach: Sweep line algorithm
    // Data Structure: TreeMap -> {point, (height, isStart)}
    // 1 to mark a starting point and -1 to mark a ending point
    static class Pair{
        private int height;
        private boolean isStart;
        Pair(int height, boolean isStart) {
            this.height = height;
            this.isStart = isStart;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public boolean getIsStart() {
            return isStart;
        }

        public void setIsStart(boolean isStart) {
            this.isStart = isStart;
        }

        @Override
        public String toString() {
            String s = "height -> "+height ;
            if(isStart) {
                s += " starting point";
            } else{
                s += " ending point";
            }
            return s;
        }
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer, Pair> map = new TreeMap<>();
        HashSet<Integer> alreadyEnded = new HashSet<>();
        // alreadyEnded stores the ending points if the current element is also ending so that we can ignore the start points
        // iterate the buildings array to build the treemap
        for(int[] building: buildings) {
            map.put(building[0], new Pair(building[2],true ));
            map.put(building[1], new Pair(building[2], false));
        }
        List<List<Integer>> ans = new ArrayList<>();
        System.out.println(map);

        // now you have to iterate the tree map
        for(Map.Entry<Integer, Pair> entry: map.entrySet()) {
            Integer point = entry.getKey();
            Pair pair = entry.getValue();
            int height = pair.getHeight();
            boolean isStart = pair.getIsStart();
            if(isStart) {
                // then you need to check that the height of the floor should be smaller than this, then you can add this to your answer
                if(ans.isEmpty()) {
                    // this is the first element, directly add it
                    ans.add(List.of(point, height));
                } else{
                    // you need the height of the floor entry
                    Map.Entry<Integer, Pair> floorEntry = map.floorEntry(point-1);
                    int prevHeight = floorEntry.getValue().getHeight();
                    if(prevHeight<height) {
                        ans.add(List.of(point, height));
                    }
                }
            } else{
                // this is the end, so we need the max of left's starting point only
                // start iteration from the current point -1
                int maxHeight = 0;
                boolean flag = false;
                // Iterates through entries strictly smaller than currentKey in reverse order
                for(Map.Entry<Integer, Pair> prevEntry: map.headMap(point, false).descendingMap().entrySet()) {
                    // if it is an ending point, mark it as alreadyEnded
                    if(!prevEntry.getValue().getIsStart()) {
                        alreadyEnded.add(prevEntry.getValue().getHeight());
                    } else {
                        // this is starting now, so we need to check that its height is not there in the already ended
                        int prevHeight = prevEntry.getValue().getHeight();
                        if(!alreadyEnded.contains(prevHeight)) {
                            // then this is a valid candidate
                            if(prevHeight>height) {
                                flag = true;
                                continue;
                            }
                            maxHeight= Math.max(maxHeight, prevHeight);
                        }
                    }
                }
                // and to add this to our answer, the maxHeight should be smaller than the currentHeight because it is landing, if you cant find one, then it is 0
                if(maxHeight!=0) {
                    ans.add(List.of(point, maxHeight));
                } else if(!flag) {
                    ans.add(List.of(point, 0));
                }
            }
        }

        return ans;

    }

    static void main() {
        System.out.println(getSkyline(new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}}));
    }
}
