import java.util.Arrays;

public class CoinChange {
    private int f(int[] coins, int i, int amount, int[][] dp){
        if(i<0 || amount<0) return (int)1e9;
        if(amount==0) return 0;
        if(i==0 && amount==0) return 0;
        if(i==0 && amount%coins[0]==0){
            return amount/coins[0];
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int dontInclude = f(coins, i-1, amount, dp);
        int include = (int) 1e9;
        if(coins[i]<=amount){
            include = 1 + f(coins, i, amount-coins[i], dp);
        }
        return dp[i][amount]=Math.min(dontInclude, include);
    }
    public int MinimumCoinsMemoization(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans= f(coins, coins.length-1, amount, dp);
        return ans>=1e9?-1:ans;
    }
    public int MinimumCoinsTabulation(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        int INF = (int)1e9;
        //amount==0 means the first column has to be set to 0, which it already is
        //now for the first index, where it is possible to have multiple amounts by that, fill that in
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i]= i/coins[0];
            }
            else{
                dp[0][i]=INF;
            }
        }
        //done with the base cases, now move to the bottom-up iteration
        for(int i=1;i<coins.length;i++){
            for(int j= 0; j<=amount; j++){
                int dontInclude = dp[i-1][j];
                int include = INF;
                //check if it is possible to spare those coins to reach amount
                if(j-coins[i]>=0){
                    include = 1 + dp[i][j-coins[i]];
                }
                dp[i][j]= Math.min(dontInclude, include);
            }
        }
        int ans= dp[coins.length-1][amount];
        if(ans>=INF) return -1;
        else return ans;
    }
    public int MinimumCoins(int[] coins, int amount) {
        int[] prev = new int[amount+1];
        int[] curr= new int[amount+1];
        int INF = (int)1e9;
        //amount==0 means the first column has to be set to 0, which it already is
        //now for the first index, where it is possible to have multiple amounts by that, fill that in
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                prev[i]= i/coins[0];
            }
            else{
                prev[i]=INF;
            }
        }
        //done with the base cases, now move to the bottom-up iteration
        for(int i=1;i<coins.length;i++){
            for(int j= 0; j<=amount; j++){
                int dontInclude = prev[j];
                int include = INF;
                //check if it is possible to spare those coins to reach amount
                if(j-coins[i]>=0){
                    include = 1 + curr[j-coins[i]];
                }
                curr[j]= Math.min(dontInclude, include);
            }
            prev = curr;
            curr= new int[amount+1];
        }
        int ans= prev[amount];
        if(ans>=INF) return -1;
        else return ans;
    }
}
