import java.util.Arrays;

public class UnboundedKnapsack {
    private int f(int[] wt, int[] val, int i, int W,int[][] dp){
        if(i<0 || W<0) return 0;
        if(i==0){
            if(W%wt[i]==0) return (W/wt[i]*val[i]);
            if(W<=0) return 0;
        }
        if(dp[i][W]!=-1) return dp[i][W];
        int dontInclude= f(wt,val, i-1, W,dp);
        int include =0;
        if(W-wt[i]>=0){
            include = val[i] + f(wt, val, i, W-wt[i],dp);
        }
        return dp[i][W]= Math.max(include, dontInclude);
    }
    public int unboundedKnapsackMemoization(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(wt, val, n-1, W, dp);
    }
    public int unboundedKnapsackTabulation(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W+1];
        // base case
        for(int w=0; w<=W;w++){
                dp[0][w] = (w/wt[0]*val[0]);

        }
        //iteration
        for(int i=1;i<n;i++){
            for(int w=0;w<=W;w++){
                int dontInclude = dp[i-1][w];
                int include = 0;
                if(w-wt[i]>=0){
                    include = val[i]+dp[i][w-wt[i]];
                }
                dp[i][w]= Math.max(include, dontInclude);
            }
        }
        return dp[n-1][W];
    }
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W+1];
        int[] curr = new int[W+1];

        for(int w=0;w<=W;w++){
            prev[w]=(w/wt[0]*val[0]);
        }
        for(int i=1;i<n;i++){
            for(int w=0;w<=W;w++){
                int dontInclude = prev[w];
                int include = 0;
                if(w-wt[i]>=0){
                    include = val[i]+curr[w-wt[i]];
                }
                curr[w]= Math.max(include, dontInclude);
            }
            prev= curr;
            curr= new int[W+1];
        }
        return prev[W];


    }
}
