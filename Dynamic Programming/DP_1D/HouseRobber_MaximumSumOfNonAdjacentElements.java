package DP_1D;

import java.util.*;

public class HouseRobber_MaximumSumOfNonAdjacentElements {
    private int f(int[] nums, int ind, int[] dp){
        if(ind<0) return 0;
        if(ind==0) return nums[0];
        if(dp[ind]!=-1) return dp[ind];
        int include= nums[ind] + f(nums, ind-2, dp);
        int dont_include= f(nums, ind-1, dp);
        dp[ind]= Math.max(include, dont_include);
        return dp[ind];
    }

    public int nonAdjacent(int[] nums) {
        int n= nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return Math.max(f(nums, n-1, dp), f(nums, n-2, dp));
    }
    public int nonAdjacentTabulation(int[] nums) {
        int n= nums.length;
        int[] dp = new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            if(i-2<0){
                dp[i]=Math.max(nums[i], dp[i-1]);
            }
            else{
                dp[i]= Math.max(nums[i]+ dp[i-2], dp[i-1]);
            }
        }
        return dp[n-1];
    }
    public int nonAdjacentSpaceOptimized(int[] nums){
        int n= nums.length;
        //at any instance I just need the i-1 and the i-2 index
        int prev1= 0;
        int prev2=0;
        prev1= nums[0];
        for(int i=1;i<n;i++){
            int maxNow= Math.max(prev2+ nums[i], prev1);
            prev2= prev1;
            prev1= maxNow;
        }
        return prev1;
    }
}
