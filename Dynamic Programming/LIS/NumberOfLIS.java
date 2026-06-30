package LIS;

import java.util.Arrays;

public class NumberOfLIS {
    public static  int numberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int[] count = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(count,1);
        int maxi = 0;
        int maxIndex=0;
        for(int i=1;i<len;i++){
            for(int prev_ind= 0; prev_ind<i; prev_ind++){
                if(nums[prev_ind]<nums[i] && dp[i]<dp[prev_ind]+1){
                    dp[i]= dp[prev_ind]+1;
                    count[i]=count[prev_ind];
                }
                //if there is a same way to make it, include that many ways into count
                else if(nums[prev_ind]<nums[i] && dp[i]==dp[prev_ind]+1){
                    count[i]+=count[prev_ind];
                }
            }
            if(maxi<dp[i]){
                maxi = dp[i];
            }
        }
        int ans=0;
        for(int i=0;i<len;i++){
            if(dp[i]==maxi){
                ans+= count[i];
            }
        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(count));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOfLIS(new int[]{1,5,4,3,2,6,7,10,8,9}));
    }
}
