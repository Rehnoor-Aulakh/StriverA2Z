package DP_1D;

import java.util.Arrays;

public class FrogJump {
    private static int f(int ind, int[] heights, int[] dp){

        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int left= f(ind-1, heights, dp) + Math.abs(heights[ind]-heights[ind-1]);
        int right= Integer.MAX_VALUE;
        if(ind>1){
            right= f(ind-2, heights, dp) + Math.abs(heights[ind]- heights[ind-2]);
        }
        dp[ind]=Math.min(left, right);
        return dp[ind];
    }

    public static int frogJump(int[] heights) {
        int n= heights.length;
        int[] dp= new int[n+1];
        Arrays.fill(dp, -1);
        return f(n-1, heights,dp);
    }
    public static int frogJumpTabulation(int[] heights){
        int n= heights.length;
        int[] dp = new int[n];
        dp[0]=0;
        for(int i=1;i<n; i++){
            int left= dp[i-1]+ Math.abs(heights[i]-heights[i-1]);
            int right= Integer.MAX_VALUE;
            if(i>1){
                right= dp[i-2]+ Math.abs(heights[i]- heights[i-2]);
            }
            dp[i]=Math.min(left, right);
        }
        return dp[n-1];
    }
    public static int frogJumpSpaceOptimized(int[] heights){
        int n= heights.length;
        int i_2=0;
        int i_1= 0;
        for(int i=1;i<n;i++){
            int left= i_1 + Math.abs(heights[i]-heights[i-1]);
            int right= Integer.MAX_VALUE;
            if(i>1){
                right= i_2 + Math.abs(heights[i]-heights[i-2]);
            }
            i_2=i_1;
            i_1= Math.min(left,right);

        }
        return i_1;

    }
    public static void main(String[] args) {
        int[] arr={7, 5, 1, 2, 6};
        System.out.println(frogJump(arr));
    }
}