import java.util.Arrays;

public class RodCuttingProblem {
    private int f(int[] price, int i, int length, int[][] dp){
        if(i<0 || length<0) return 0;
        if(i==0){
            //the remaining length has to come from index 0
            return (length/(i+1)*price[i]);
        }
        if(dp[i][length]!=-1) return dp[i][length];
        int dontInclude = f(price, i-1, length, dp);
        int include = 0;
        if(length-(i+1)>=0){
            include = price[i]+ f(price, i, length-(i+1), dp);
        }
        return dp[i][length] = Math.max(include, dontInclude);
    }
    public int RodCuttingMemoization(int price[], int n) {
        int size= price.length;
        int[][] dp = new int[size][n+1];
        for(int i=0;i<size;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(price, size-1, n, dp);
    }
    public int RodCuttingTabulation(int[] price, int n){
        int size = price.length;
        int[][] dp = new int[size][n+1];
        //base case
        for(int length=0;length<=n;length++){
            dp[0][length]= (length*price[0]);
        }
        for(int i=1;i<size;i++){
            for(int length =0; length<=n; length++){
                int dontInclude = dp[i-1][length];
                int include = 0;
                if(length-(i+1)>=0){
                    include = price[i] + dp[i][length-(i+1)];
                }
                dp[i][length]= Math.max(include,dontInclude);
            }
        }
        return dp[size-1][n];
    }
    public int RodCutting(int[] price, int n){
        int size = price.length;
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        //base case
        for(int length=0;length<=n;length++){
            prev[length]= (length*price[0]);
        }
        for(int i=1;i<size;i++){
            for(int length =0; length<=n; length++){
                int dontInclude = prev[length];
                int include = 0;
                if(length-(i+1)>=0){
                    include = price[i] + curr[length-(i+1)];
                }
                curr[length]= Math.max(include,dontInclude);
            }
            prev =curr;
            curr= new int[n+1];
        }
        return prev[n];
    }
}
