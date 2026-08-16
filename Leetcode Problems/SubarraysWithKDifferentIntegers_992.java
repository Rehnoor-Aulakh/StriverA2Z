import java.util.HashMap;

public class SubarraysWithKDifferentIntegers_992 {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k)- atMostK(nums, k-1);
    }
    private static int atMostK(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0;
        int n= nums.length, count = 0;
        for(right = 0; right<n; right++) {
            // include this in hashmap
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            // then need to check if hashmap is valid

                // need to remove elements from left till it becomes valid
                while(freqMap.size() > k) {
                    int freq = freqMap.get(nums[left]);
                    if(freq-1==0) {
                        // just remove this from map
                        // but currently this is still valid
                        // now the next time it would be invalid
                        freqMap.remove(nums[left]);
                    } else {
                        // this is still a valid subarray
                        freqMap.put(nums[left], freq-1);
                    }
                    left++;
                }
                count+= (right-left+1);

        }
        return count;
    }

    static void main() {
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
    }
}
