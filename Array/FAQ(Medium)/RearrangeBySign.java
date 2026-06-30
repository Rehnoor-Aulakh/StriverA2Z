import java.util.*;

public class RearrangeBySign{
    public static int[] rearrangeArray(int[] nums){

        int pos=0;
        int neg=1;
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                ans[neg]=nums[i];
                neg+=2;
            }
            else{
                ans[pos]=nums[i];
                pos+=2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={2, 4, 5, -1, -3, -4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));        
    }
}