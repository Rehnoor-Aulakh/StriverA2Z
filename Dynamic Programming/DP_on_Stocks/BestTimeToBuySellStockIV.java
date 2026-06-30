package DP_on_Stocks;

public class BestTimeToBuySellStockIV {
    public int stockBuySell(int[] arr, int n, int k) {
        int[][] after= new int[2][k+1];
        int[][] curr= new int[2][k+1];

        for(int i = n-1 ; i>=0 ; i--){
            for(int canBuy=0; canBuy<=1; canBuy++){
                for(int cap = 1; cap<=k ; cap++){
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
        return after[1][k];
    }
}
