import java.util.HashMap;

public class CountSubarraysWithGivenXOR {
    public int subarraysWithXorK(int[] nums, int k) {
        int prefixXor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // {prefixXor, count}
        map.put(0,1);
        int count = 0;
        for(int i=0; i< nums.length; i++) {
            prefixXor = prefixXor ^ nums[i];
            if(map.containsKey(prefixXor^k)) {
                count += map.get(prefixXor ^ k);
            }
            if(map.containsKey(prefixXor)) {
                map.put(prefixXor, map.get(prefixXor) + 1);
            } else{
                map.put(prefixXor, 1);
            }
        }
        return count;
    }
}
