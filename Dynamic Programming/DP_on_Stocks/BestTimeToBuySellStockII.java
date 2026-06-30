package DP_on_Stocks;
import java.util.*;

public class BestTimeToBuySellStockII {
    static int f(int[] arr, int i, int canBuy, int[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][canBuy]!=-1){
            return dp[i][canBuy];
        }
        //there are 2 possibilities, buy or dont buy
        if(canBuy==1){
            //this means you can buy or not buy this stock
            dp[i][canBuy]=Math.max(f(arr, i+1, 1, dp), -arr[i]+ f(arr, i+1, 0, dp));
            return dp[i][canBuy];
        }
        else{
            // you can sell this stock or keep it
            dp[i][canBuy]= Math.max(arr[i] + f(arr, i+1, 1, dp), f(arr, i+1, 0, dp));
            return dp[i][canBuy];
        }
    }
    public static int stockBuySellMemoization(int[] arr, int n) {
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return f(arr, 0, 1, dp);
    }
    public static int stockBuySellTabulation(int[] arr, int n){
        int[][] dp = new int[n+1][2];
        //base case
        dp[n][0]=dp[n][1]=0;

        for(int i=n-1 ; i>=0 ; i--){
            for(int canBuy= 0; canBuy<=1; canBuy++){
                if(canBuy==1){
                    //this means you can buy or not buy this stock
                    dp[i][canBuy]=Math.max(dp[i+1][1], -arr[i]+ dp[i+1][0]);

                }
                else{
                    // you can sell this stock or keep it
                    dp[i][canBuy]= Math.max(arr[i] + dp[i+1][1], dp[i+1][0]);

                }
            }
        }
        // return where the canBuy =1 because at 0, you are allowed to buy
        return dp[0][1];
    }
    public static int stockBuySell(int[] arr, int n){
        int[] prev= new int[2];
        int[] curr= new int[2];
        for(int i=n-1 ; i>=0 ; i--){
            for(int canBuy= 0; canBuy<=1; canBuy++){
                if(canBuy==1){
                    //this means you can buy or not buy this stock
                    curr[canBuy]=Math.max(prev[1], -arr[i]+ prev[0]);

                }
                else{
                    // you can sell this stock or keep it
                    curr[canBuy]= Math.max(arr[i] + prev[1], prev[0]);

                }
            }
            prev= curr;
        }
        return prev[1];
    }

    public static void main() {
        int[] arr= {7,1,5,3,6,4};
        System.out.println(stockBuySell(arr, arr.length));
    }
}
