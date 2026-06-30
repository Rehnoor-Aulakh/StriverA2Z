import java.util.Arrays;

public class Knapsack01 {
    private int f(int[] wt, int[] val, int W, int i, int[][] dp){
        if(i<0) return 0;
        if(i==0 && wt[0]<=W) return val[0];
        if(dp[i][W]!=-1) return dp[i][W];
        int dontInclude= f(wt, val, W, i-1, dp);
        int include = 0;
        if(wt[i]<=W){
            include= val[i] + f(wt, val, W-wt[i], i-1,dp);
        }
        return dp[i][W] =  Math.max(dontInclude, include);
    }
    public int knapsack01Memoization(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(wt, val, W, n-1, dp);
    }
    public int knapsack01Tabulation(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W+1];
        for(int weight=wt[0]; weight<=W;weight++){
            dp[0][weight]= val[0];
        }
        for(int i=1;i<n;i++){
            for(int weight = 0; weight<=W; weight++){
                int dontInclude= dp[i-1][weight];
                int include = 0;
                if(wt[i]<=weight){
                    include= val[i]+ dp[i-1][weight-wt[i]];
                }
                dp[i][weight] = Math.max(include, dontInclude);
            }
        }
        return dp[n-1][W];
    }
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        int prev[]= new int[W+1];
        int curr[]= new int[W+1];
        for(int weight=wt[0]; weight<=W;weight++){
            prev[weight]= val[0];
        }
        for(int i=1;i<n;i++){
            for(int weight = 0; weight<=W; weight++){
                int dontInclude= prev[weight];
                int include = 0;
                if(wt[i]<=weight){
                    include= val[i]+ prev[weight-wt[i]];
                }
                curr[weight] = Math.max(include, dontInclude);
            }
            prev= curr;
            curr= new int[W+1];
        }
        return prev[W];
    }

}
