package DP_1D;

import java.util.*;

public class FromJumpKDistance {
    private static int f(int[] heights, int k, int ind, int[] dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int minSteps= Integer.MAX_VALUE;
        for(int i=ind-1;i>=Math.max(0, ind-k); i--){
            minSteps= Math.min(minSteps, f(heights, k, i, dp) + Math.abs(heights[ind]-heights[i]));
        }
        dp[ind]=minSteps;
        return minSteps;
    }
    public static int frogJump(int[] heights, int k) {
        int n= heights.length;
        int dp[]= new int[n];
        Arrays.fill(dp,-1);
        dp[0]=0;
        return f(heights, k, heights.length-1, dp);
    }
    public static int frogJumpTabulation(int[] heights, int k){
        int n= heights.length;
        int dp[]= new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<n;i++){
            //then there is a loop of k steps backwards
            for(int j=i-1;j>=Math.max(0, i-k);j--){
                dp[i]=Math.min(dp[i], dp[j]+ Math.abs(heights[i]-heights[j]));
            }
        }
        return dp[n-1];
    }
    public static int frogJumpSpaceOptimized(int[] heights, int k){
        int n= heights.length;
        List<Integer> dp= new ArrayList<>();
        dp.add(0);
        int currBest =0;
        for(int i=1;i<n;i++){
             currBest= Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(j<=dp.size()){
                    int prev= dp.get(dp.size()-j);
                    int jump = prev+ Math.abs(heights[i]-heights[i-j]);
                    currBest= Math.min(currBest, jump);
                    //remove the front element from arraylist
                }
            }
            if(dp.size()==k){
                dp.remove(0);
            }
            dp.add(currBest);
        }
        return currBest;
    }
    public static void main(String[] args) {
        int[] arr={15, 4, 1, 14, 15};
        System.out.println(frogJumpSpaceOptimized(arr, 3));
    }

}
