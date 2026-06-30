import java.util.*;

public class LeadersArray{
    public static List<Integer> leaders(int[] nums){
        List<Integer> ans= new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>max){
                max=nums[i];
                ans.addFirst(nums[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={-3, 4, 5, 1, -4, -5};
        System.out.println(leaders(nums));
        
    }
}