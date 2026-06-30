import java.util.Arrays;

class Sol {
    int MOD = 1000000007;
    int[] coins;
    Sol(){
        coins= new int[]{1, 2, 4,  6};
    }
    // we will handle 4 separately
    private int f(int n, int remaining4s, int index, int[][][] dp){
        if(n<0 || index>=coins.length) return 0;
        // this is now one valid way
        if(n==0) return 1;
        if(dp[n][index][remaining4s]!=-1) return dp[n][index][remaining4s];
        int dontInclude = f(n, remaining4s, index+1, dp);
        int include= 0;
        if(n-coins[index]>=0){
            if(coins[index]==4 ){
                if(remaining4s>0)
                {
                    include = f(n-4 , remaining4s-1, index,dp);
                }
            }
            else{
                include= f(n-coins[index], remaining4s, index,dp);
                // the dontInclude will handle index+1 case
            }
        }
        return dp[n][index][remaining4s] = (include+dontInclude)%MOD;
    }
    public int numberOfWaysMemoization(int n) {
        int[][][] dp = new int[n+1][4][3];
        //initialize all with -1
        for(int i=0;i<=n;i++){
            for(int j=0;j<4;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return f(n, 2 , 0, dp);
    }
    public int numberOfWays(int n) {
        int[][][] dp = new int[n+1][5][4];
        // initialize the first row, i.e. for n==0 it should be set to 1
        for(int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                dp[0][i][j]=1;
            }
        }
        // I need 3 loops
        for(int i=0;i<=n;i++){
            for(int index= 3;index>=0; index--){
                for(int remaining4s = 0; remaining4s<=2; remaining4s++){
                    int dontInclude = dp[i][index+1][remaining4s];;
                    int include= 0;
                    if(i-coins[index]>=0){
                        if(coins[index]==4 ){
                            if(remaining4s>0)
                            {
                                include = dp[i-4][index][remaining4s-1];
                            }
                        }
                        else{
                            include= dp[i-coins[index]][index][remaining4s];
                            // the dontInclude will handle index+1 case
                        }
                    }
                    dp[i][index][remaining4s] = (include+dontInclude)%MOD;
                }
            }
        }
        return dp[n][0][2];
    }

}

public class NumberOfWaysToMakeTheSum{
    static void main() {
        Sol obj = new Sol();
        System.out.println( obj.numberOfWays(10));
    }
}