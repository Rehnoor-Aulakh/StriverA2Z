package Hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
        if((o.y - o.x) < (this.y-this.x)) {
            return 1;
        } return -1;
    }
}

 class MaxValueOfEquation_1499PQ {
    public int findMaxValueOfEquation(int[][] points, int k) {
        // max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int candidateAns = Integer.MIN_VALUE;
        for(int[] point: points) {
            // pop elements till the first constraint is satisfied
            while(!pq.isEmpty() && Math.abs(pq.peek().x - point[0])>k) {
                pq.poll();
            }
            // after this you can find candidate answer and push the element to priority queue
            if(!pq.isEmpty()) {
                candidateAns = Math.max(candidateAns, pq.peek().y - pq.peek().x + point[0]+ point[1] );
            }
            pq.add(new Pair(point[0], point[1]));
        }
        return candidateAns;
    }
}

public class MaxValueOfEquation_1499{
    public int findMaxValueOfEquation(int[][] points, int k){
        Deque<Pair> deque = new ArrayDeque<>();
        // we will maintain a monotonic deque which is better than PQ because of O(1) insertion and deletion operations while maximum access is still O(1) because of sorted order
        int candidateAns = Integer.MIN_VALUE;
        for(int[] point: points) {
            while(!deque.isEmpty() && Math.abs(deque.peekLast().x - point[0])>k) {
                deque.pollLast();
            }
            if(!deque.isEmpty()) {
                candidateAns = Math.max(candidateAns, deque.peekLast().y - deque.peekLast().x + point[0] + point[1]);
            }
            deque.add(new Pair(point[0], point[1]));
        }
        return candidateAns;
    }

}
