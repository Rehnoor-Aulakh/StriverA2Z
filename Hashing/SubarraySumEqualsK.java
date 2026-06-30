
import java.util.*;

public class SubarraySumEqualsK{
    public static int subarraySum(int[] nums, int k){
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0, 1);
        //store, data,frequency
        int count=0;
        int prefixSum=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            //if prefix sum -k exists, update count
            if(map.containsKey(prefixSum-k)){
                count+=map.get(prefixSum-k);
            }
            //if this prefixsum exists in map, update it
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int nums[]={3,-3,1,1,1};
        System.out.println(subarraySum(nums, 0));
    }
}