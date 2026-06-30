
import java.util.Arrays;

public class MaxConsecutiveOnes{
    public static int longestOnes(int[] nums, int k) {
        if(k==0){
            int max=0,curr=0;
            for(int num: nums){
                curr= (num==1)?curr+1:0;
                max=Math.max(max,curr);
            }
            return max;
        }
        int[] k_arr = new int[k];
        Arrays.fill(k_arr, -1);
        //i need to once iterate over nums
        int left=0;
        int maxLen=0;
        int curr_pos=0;
        for(int right=0;right<nums.length;right++){
            //include the right if it is 1
            if(nums[right]==0){
                //set left to the minimum value of k_arr
                //you need to set the curr_pos of k_arr to right
                if(k_arr[curr_pos]!=-1){
                    left=k_arr[curr_pos]+1;
                }
                k_arr[curr_pos] = right;
                curr_pos=(curr_pos+1)%k;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[]  nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums, 2));
    }
}