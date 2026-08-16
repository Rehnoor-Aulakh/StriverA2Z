import java.util.*;

public class ConstrainedSubsequenceSum_1425 {
    public static int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int maxDp = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            // 1. Remove indices outside the window [i-k,i-1], maintaining decreasing order of dp[i]
            if(!deque.isEmpty() && deque.peekFirst() < i-k) {
                deque.pollFirst();
            }
            // 2. Maximum dp in the window is at the front of deque
            int maxInWindow = deque.isEmpty() ? 0 : Math.max(0,dp[deque.peekFirst()]);
            dp[i] = nums[i] + maxInWindow;

            // 3. Maintain decreasing order: pop smaller values from the back
            while(!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            maxDp = Math.max(maxDp, dp[i]);
        }
        return maxDp;

    }
    static void main() {
        System.out.println(constrainedSubsetSum(new int[]{10,2,-10,5,20}, 2));
    }
}
