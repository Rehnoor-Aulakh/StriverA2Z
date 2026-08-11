package PriorityQueueQuestions;
import java.util.*;

public class SkyLineProblem {
    static class Pair implements Comparable<Pair> {
        int x;
        int height;
        public Pair(int x, int height) {
            this.x = x;
            this.height = height;
        }
        @Override
        public int compareTo(Pair o) {
            if(this.x != o.x) {
                // sort in ascending order
                // if this.x is larger then it would return 1,and then sort
                return this.x - o.x;
            } else {
                // if the x coordinate is same, then we want to sort by increasing order of height,
                // because start point's heights are negative
                // so eventually bigger height would be on the left
                return this.height - o.height;
            }

        }
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> list = new ArrayList<>();
        for(int[] building: buildings) {
            // start point
            list.add(new Pair(building[0], -building[2]));
            // end point
            list.add(new Pair(building[1], building[2]));
        }
        Collections.sort(list);
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int currentHeight = 0;
        pq.add(0);
        for(Pair p: list) {
            int x= p.x;
            int height = p.height;
            // starting point
            if(height < 0 ) {
                pq.add(-height);

            } else {
                // it is an end point, so we need to remove it from the priority queue
                pq.remove(height);
            }
            if(currentHeight != pq.peek()) {
                List<Integer> t = new ArrayList<>();
                t.add(x);
                t.add(pq.peek());
                ans.add(t);
                currentHeight = pq.peek();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(getSkyline(buildings));
    }
}
