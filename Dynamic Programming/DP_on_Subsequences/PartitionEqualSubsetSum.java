package DP_on_Subsequences;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    boolean f(int[] nums, int i, int sum1, int sum2){
        //base case
        if(i==nums.length && sum1==sum2) return true;
        //out of bound case
        if(i==nums.length) return false;
        //2 options, either add this in sum1 or sum2
        return f(nums, i+1, sum1+nums[i], sum2) || f(nums, i+1, sum1, sum2+nums[i]);
    }
    static boolean f(int[] arr, int target, int i, int[][] dp){
        if(target==0) return true;
        if(i==0) return arr[0]==target;
        //out of bound case
        if(i<0) return false;
        if(dp[i][target]!=-1) return dp[i][target] == 1;
        //otherwise include or dont include
        boolean dontInclude= f(arr, target, i-1, dp);
        boolean include= false;
        if(target >= arr[i]){
            include=  f(arr, target - arr[i], i - 1, dp);
        }
        dp[i][target] = (dontInclude || include) ?1:0;
        return dp[i][target] == 1;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        int[][] dp = new int[nums.length][sum+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(nums, sum/2, nums.length-1, dp);
    }

    public static void main() {
        PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
        System.out.println(obj.canPartition(new int[]{1,5,11,5}));
    }
}
