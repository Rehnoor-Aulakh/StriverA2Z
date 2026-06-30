
import java.util.HashMap;

public class SubarraysWithXorK{
    public static int subarraysWithXorK(int[] nums, int k){
        int prefixXOR= 0;
        int count=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0, 1);
        // prefixXor, count
        for(int i=0; i<nums.length;i++){
            prefixXOR=prefixXOR^nums[i];

            if(map.containsKey(prefixXOR^k)){
                count+=map.get(prefixXOR^k);
            }
            map.put(prefixXOR,map.getOrDefault(prefixXOR, 0)+1);            
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums={4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(subarraysWithXorK(nums, k));
    }
}