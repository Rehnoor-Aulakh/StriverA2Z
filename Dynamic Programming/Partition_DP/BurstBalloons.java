package Partition_DP;

import java.util.*;

public class BurstBalloons {
    private int f(List<Integer> arr, int i, int j, int[][] dp){
        if(j<i) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxi= Integer.MIN_VALUE;
        for(int ind = i; ind<=j;ind++){
            int ans= (arr.get(i-1)*arr.get(ind)*arr.get(j+1) ) + f(arr, i, ind-1,dp ) + f(arr, ind+1, j, dp);
            maxi= Math.max(maxi, ans);
        }
        return dp[i][j]= maxi;
    }
    public int maxCoinsMemoization(int[] nums) {
        int size= nums.length;
        List<Integer> arr = new ArrayList<>();
        int[][] dp = new int[size+2][size+2];
        for(int i=0;i<size+2;i++){
            Arrays.fill(dp[i],-1);
        }
        arr.add(1);
        for(int num: nums){
            arr.add(num);
        }
        arr.add(1);
        return f(arr, 1, size,dp);
    }
    public int maxCoins(int[] nums){
        int size= nums.length;
        List<Integer> arr = new ArrayList<>();
        int[][] dp = new int[size+2][size+2];
        arr.add(1);
        for(int num: nums){
            arr.add(num);
        }
        arr.add(1);
        for(int i=size;i>=1;i--){
            for(int j = i; j<=size;j++){
                int maxi= Integer.MIN_VALUE;
                for(int ind = i; ind<=j;ind++){
                    int ans= (arr.get(i-1)*arr.get(ind)*arr.get(j+1) ) + dp[i][ind-1] + dp[ind+1][j];
                    maxi= Math.max(maxi, ans);
                }
                 dp[i][j]= maxi;
            }
        }
        return dp[1][size];
    }

    public static void main(String[] args) {
        BurstBalloons obj = new BurstBalloons();
        System.out.println(obj.maxCoins(new int[]{3,1,5,8}));
    }
}
