package Partition_DP;

import java.util.Arrays;

public class MatrixChainMultiplication {
    private int f(int[] nums, int i, int j,int[][] dp){
        if(i==j) return 0;
        int mini= (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i;k<j;k++){
            mini= Math.min(mini, (nums[i-1]*nums[k]*nums[j])+f(nums,i,k,dp)+f(nums,k+1,j,dp));
        }
        return dp[i][j]=mini;
    }
    public int matrixMultiplicationMemoization(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(nums, 1, nums.length-1,dp);
    }
    public int matrixMultiplication(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size][size];
        for(int i=size-1;i>0;i--){
            for(int j=i+1;j<size;j++){
                int mini= (int)1e9;
                for(int k=i;k<j;k++){
                    mini= Math.min(mini, (nums[i-1]*nums[k]*nums[j])+dp[i][k]+dp[k+1][j]);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][size-1];
    }
    public static void main(String[] args) {
        int[] arr= {10, 15, 20, 25};
        MatrixChainMultiplication obj = new MatrixChainMultiplication();
        System.out.println(obj.matrixMultiplication(arr));
    }

}

