
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement{
    public static int majorityElementMooreAlgo(int[] nums){
        int count=0;
        int element=-1;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                count=1;
                element=nums[i];
            }
            else if(nums[i]==element){
                count++;
            }
            else{
                count--;
            }
        }
        return element;
    }
    
    public static int majorityElement(int[] nums){
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i:nums){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        //now just iterate the Map set to find the maximum value and return its key

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if(entry.getValue()>nums.length/2){
                return entry.getKey();
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[]={7, 0, 0, 1, 7, 7, 2, 7, 7};
        // System.out.println(majorityElement(nums));
        System.out.println(Arrays.toString(nums));
        System.out.println(majorityElementMooreAlgo(nums));
    }
}