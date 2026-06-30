import java.util.*;

public class NumberOfJumps {
    public int NumberOfJumps(int[] nums, int k) {
        // use TreeMap to preserve elements and their frequencies
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;

        // traverse the array from right to left
        for(int i = nums.length-1 ; i>=0; i--){
            int threshold = nums[i]+k;
            // from the TreeMap, you can find the upper bound using the map.tailMap() function and in it, add the threshold above which you want, and it will give you the entry set
            for(Map.Entry entry: map.tailMap(threshold+1).entrySet()){
                count += (int)entry.getValue();
            }
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
}
