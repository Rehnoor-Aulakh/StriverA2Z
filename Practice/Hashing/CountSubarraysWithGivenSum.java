import java.util.HashMap;

public class CountSubarraysWithGivenSum {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int prefixSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // {prefixSum, count}
        map.put(0,1);
        for(int i=0; i<len; i++) {
            prefixSum+=nums[i];
            if(map.containsKey(prefixSum-k)) {
                // then this means we have that element in the array
                count+=map.get(prefixSum-k);
            }
            if(map.containsKey(prefixSum)) {
                map.put(prefixSum, map.get(prefixSum) + 1);
            }
            else{
                map.put(prefixSum, 1);
            }
        }
        return count;
    }
}
