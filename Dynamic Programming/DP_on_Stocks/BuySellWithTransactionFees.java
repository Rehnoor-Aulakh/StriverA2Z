package DP_on_Stocks;

import java.util.Arrays;

public class BuySellWithTransactionFees {
    static int f(int[] arr, int fee, int i, int canBuy, int[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][canBuy]!=-1) return dp[i][canBuy];
        if(canBuy==1){
            // buy this or dont buy this
            return dp[i][canBuy]= Math.max(-arr[i] + f(arr, fee, i+1, 0, dp), f(arr, fee, i+1,1, dp));
        }
        else{
            // sell this or dont sell this
            return dp[i][canBuy]= Math.max(arr[i]-fee + f(arr, fee, i+1, 1,dp), f(arr, fee, i+1,0, dp));
        }
    }
    public static int maxProfitMemoization(int[] arr, int fee) {
        int n = arr.length;
        int[][] dp = new int[n+1][2];
        for(int i=0;i<=n ; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(arr,fee, 0, 1, dp);
    }

    public static int maxProfitTabulation(int[] arr, int fee) {
        int n = arr.length;
        int[][] dp = new int[n+1][2];

        for(int i=n-1; i>=0; i--){
            for(int canBuy = 0;canBuy<=1;canBuy++){
                if(canBuy==1){
                    // buy this or dont buy this
                    dp[i][canBuy]= Math.max(-arr[i] + dp[i+1][0], dp[i+1][1]);
                }
                else{
                    // sell this or dont sell this
                    dp[i][canBuy]= Math.max(arr[i]-fee + dp[i+1][1], dp[i+1][0] );
                }
            }
        }
        return dp[0][1];
    }
    public static int maxProfit(int[] arr, int fee){
        int n =arr.length;
        int[] curr= new int[2];
        int[] ahead= new int[2];
        for(int i=n-1; i>=0;i--){
            for(int canBuy = 0; canBuy<=1;canBuy++){
                if(canBuy==1){
                    curr[canBuy]= Math.max(-arr[i] + ahead[0], ahead[1]);
                }
                else{
                    curr[canBuy]= Math.max(arr[i]-fee + ahead[1], ahead[0]);
                }
            }
            ahead= curr;
        }
        return ahead[1];
    }

    static void main() {
        int[] arr={1,3,2,8,4,9};
        System.out.println(maxProfit(arr, 2));
    }
}
