import java.util.Arrays;

public class MinimumSizeSubarraySum_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        // my approach for this question is to use sliding window here
        // keep a left, right and a runningSum
        if(nums.length==0) return 0;
        int left = 0,  sum = 0;
        // now if sum < target, we need to expand right
        // if sum>target, we need to shrink left
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        for(int right=0; right<n; right++) {
            sum += nums[right];

            while(sum>=target) {
                // shrink from left
                minLen = Math.min(minLen, right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    // binary search on answers approach
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = n-1;
        int candidateAns = -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            System.out.println(mid);
            if(isFound(nums, mid+1, k)) {
                // go left
                candidateAns = mid;
                high = mid-1;
            } else{
                System.out.println("low updated");
                low = mid+1;
            }
        }
        return candidateAns;
    }
    private static boolean isFound(int[] nums, int len, int k) {
        // we need to check if this length's window slided through nums would give me a sum of k
        int sum = 0, left = 0, right=0;
        int n = nums.length;
        // first find the initial sum
        for(right=0; right<len; right++) {
            sum+=nums[right];
            System.out.println(sum);
            if(sum>=k) return true;
        }
        for(right=len; right<n; right++){
            if(sum>=k) return true;
            sum+=nums[right];
            sum-=nums[left];
        }
        return false;
    }
    static void main() {
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }
}
