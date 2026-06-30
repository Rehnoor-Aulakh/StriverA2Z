package DP_on_Stocks;
import java.util.*;
public class BestTimeToBuySellStockIII {
    static int f(int[] arr, int i, int canBuy, int cap, int[][][] dp){
        if(i==arr.length) return 0;
        if(cap==0) return 0;
        if(dp[i][canBuy][cap]!=-1) return dp[i][canBuy][cap];
        if(canBuy==1){
            //buy it or dont buy
            return dp[i][canBuy][cap]= Math.max(-arr[i] + f(arr, i+1, 0, cap, dp), f(arr, i+1, 1, cap, dp));
        }
        else{
            //sell or dont sell
            return dp[i][canBuy][cap] = Math.max(arr[i]+f(arr, i+1, 1, cap-1, dp), f(arr, i+1, 0 , cap, dp));
        }
    }
    public static int stockBuySellMemoization(int[] arr, int n) {
        int[][][] dp = new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return f(arr, 0,1,2, dp);
    }

    public static int stockBuySellTabulation(int[] arr, int n) {
        int[][][] dp = new int[n+1][2][3];
        //write the base cases
//        for(int i=0; i<n;i++){
//            for(int buy= 0;buy<=1;buy++){
//                dp[i][buy][0]=0;
//            }
//        }
//        for(int buy=0;buy<2;buy++){
//            for(int cap=0;cap<=2;cap++){
//                dp[n][buy][cap]=0;
//            }
//        }

        for(int i = n-1 ; i>=0 ; i--){
            for(int canBuy=0; canBuy<=1; canBuy++){
                for(int cap = 1; cap<=2 ; cap++){
                    if(canBuy==1){
                        //buy it or dont buy
                        dp[i][canBuy][cap]= Math.max(-arr[i] + dp[i+1][0][cap], dp[i+1][1][cap]);
                    }
                    else{
                        //sell or dont sell
                        dp[i][canBuy][cap] = Math.max(arr[i] + dp[i+1][1][cap-1], dp[i+1][0][cap]);
                    }
                }
            }
        }


        return dp[0][1][2];
    }

    public static int stockBuySell(int[] arr, int n){
        int[][] after= new int[2][3];
        int[][] curr= new int[2][3];

        for(int i = n-1 ; i>=0 ; i--){
            for(int canBuy=0; canBuy<=1; canBuy++){
                for(int cap = 1; cap<=2 ; cap++){
                    if(canBuy==1){
                        //buy it or dont buy
                        curr[canBuy][cap]= Math.max(-arr[i] + after[0][cap], after[1][cap]);
                    }
                    else{
                        //sell or dont sell
                        curr[canBuy][cap] = Math.max(arr[i] + after[1][cap-1], after[0][cap]);
                    }
                }
            }
            after= curr;
        }
        return after[1][2];
    }

    static void main() {
        int arr[]={
            4, 2, 7, 1, 11, 5
        };
        System.out.println(stockBuySell(arr, arr.length));
    }
}
