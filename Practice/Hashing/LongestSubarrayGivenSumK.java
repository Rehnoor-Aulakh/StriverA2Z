import java.util.HashMap;

public class LongestSubarrayGivenSumK {
    public int longestSubarray(int[] nums, int k) {
        // Prefix sum question
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        for(int i=0; i<nums.length; i++) {
            prefixSum+=nums[i];
            if(prefixSum == k) {
                maxLen = Math.max(maxLen, i+1);
            }
            // if the map contains the prefixSum-k
            if(map.containsKey(prefixSum-k)) {
                maxLen = Math.max(maxLen, i-map.get(prefixSum-k));
            }
            if(!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }
    public int longestSubarrayWithOnlyPositives(int[] nums, int k) {
        int i=0,j=0;
        int len = nums.length;
        int sum=0;
        int maxLen = 0;
        while(i<len && j<len) {
            sum+=nums[j];
            if(sum==k) {
                maxLen = Math.max(maxLen, j-i);
            }
            while(sum>k) {
                sum = sum-nums[i++];
            }
            j++;

        }
        return maxLen;
    }
}
