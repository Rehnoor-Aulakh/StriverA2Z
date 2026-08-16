import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ShortestSubarrayLen_862 {
    // Monotonic Deque Approach
    public static int shortestSubarray(int[] nums, int k) {
        if(nums.length==0) return -1;
        Deque<Integer> deque = new ArrayDeque<>();
        // cumulative sum
        int n = nums.length;
        long[] cumulativeSum = new long[n];
        int sum=0;
        int minLen = Integer.MAX_VALUE;
        int j=0;
        for(j=0; j<n; j++) {
            if(j==0) {
                cumulativeSum[0] = nums[0];
            } else {
                cumulativeSum[j] = nums[j] + cumulativeSum[j-1];
            }
            if(cumulativeSum[j] >= k) minLen = Math.min(minLen, j+1);

            // need to shrink the window
            while(!deque.isEmpty() && cumulativeSum[j] - cumulativeSum[deque.peekFirst()] >= k) {
                minLen = Math.min(minLen, j - deque.peekFirst());
                deque.pollFirst();
            }

            while(!deque.isEmpty() && cumulativeSum[j] <= cumulativeSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(j);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
    static void main() {
        System.out.println(shortestSubarray(new int[]{84, -37, 37, 40, 95}, 167));
    }
}
