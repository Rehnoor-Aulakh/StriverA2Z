package Arrays;

public class BestTimeToBuySellStock_121 {
    public static int maxProfit(int[] prices) {
        // I need to keep a prefixMin of the window from 0 to i-1, and then at ith index, I can find the maxProfit
        int maxProfit = 0;
        int prefixMin = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i]-prefixMin);
            prefixMin = Math.min(prefixMin, prices[i]);
        }
        return maxProfit;
    }

    static void main() {
        System.out.println(maxProfit(new int[]{7,5,4,3,2}));
    }
}
