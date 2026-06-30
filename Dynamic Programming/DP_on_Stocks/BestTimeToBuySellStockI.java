package DP_on_Stocks;

public class BestTimeToBuySellStockI {
    public int stockBuySell(int[] arr, int n) {
        int mini= Integer.MAX_VALUE;
        int maxProf = 0;
        for(int i=0;i<n;i++){
            mini= Math.min(mini, arr[i]);
            maxProf= Math.max(maxProf, arr[i]-mini);
        }
        return maxProf;
    }
}
