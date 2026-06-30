import java.util.Arrays;

public class CoinChangeII {
    private int MOD =1000000007;
    private int f(int[] coins, int i, int amount, int[][] dp){
        if(i<0 || amount<0) return 0;
        if(i==0){
            if(amount==0 || amount%coins[0]==0) return 1;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int dontInclude = f(coins, i-1, amount, dp);
        int include = 0;
        if(amount-coins[i]>=0){
            include = f(coins, i, amount-coins[i],dp);
        }
        return dp[i][amount]=(include+dontInclude)%MOD;

    }

    public int countMemoization(int[] coins, int N, int amount) {
        int[][] dp = new int[N][amount+1];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i], -1);
        }
        return f(coins, N-1, amount,dp);
    }
    public int countTabulation(int[] coins, int N, int amount) {
        int[][] dp = new int[N][amount+1];
        //base case
        dp[0][0]=1;
        for(int amt=1;amt<=amount;amt++){
            if(amt%coins[0]==0){
                dp[0][amt]=1;
            }
        }
        //iteration
        for(int i=1;i<N;i++){
            for(int amt = 0;amt<=amount;amt++){
                int dontInclude = dp[i-1][amt];
                int include =0;
                if(amt-coins[i]>=0){
                    include= dp[i][amt-coins[i]];
                }
                dp[i][amt]= (include+dontInclude)%MOD;
            }
        }
        return dp[N-1][amount];
    }
    public int count(int[] coins, int N, int amount) {
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
        //base case
        prev[0]=1;
        for(int amt=1;amt<=amount;amt++){
            if(amt%coins[0]==0){
                prev[amt]=1;
            }
        }
        //iteration
        for(int i=1;i<N;i++){
            for(int amt = 0;amt<=amount;amt++){
                int dontInclude = prev[amt];
                int include =0;
                if(amt-coins[i]>=0){
                    include=  curr[amt-coins[i]];
                }
                curr[amt]= (include+dontInclude)%MOD;
            }
            prev = curr;
            curr= new int[amount+1];
        }
        return prev[amount];
    }
}
