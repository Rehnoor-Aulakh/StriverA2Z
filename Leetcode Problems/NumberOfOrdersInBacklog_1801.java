import java.util.*;

public class NumberOfOrdersInBacklog_1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        // MAX HEAP
        // {price, amount} ordered by price
        PriorityQueue<int[]> buyOrdersPQ = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        // MIN HEAP
        PriorityQueue<int[]> sellOrdersPQ = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int MOD = 1_000_000_007;
        // now iterate the orders
        for(int[] order: orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];
            /// check the type

            if(type==0) {       // BUY ORDER
                // match with the smallest sell orders while price condition holds
                while(amount>0 && !sellOrdersPQ.isEmpty() && sellOrdersPQ.peek()[0] <= price) {
                    int[] minSell = sellOrdersPQ.peek();
                    int executeAmount = Math.min(amount, minSell[1]);
                    // sell this much amount
                    amount-=executeAmount;
                    minSell[1] -= executeAmount;

                    if(minSell[1]==0 ) {
                        // remove this from pq since the amount became 0
                        sellOrdersPQ.poll();
                    }
                }
                if(amount>0) {
                    buyOrdersPQ.add(new int[]{price, amount});
                }
            } else {            // SELL ORDER
                while(amount>0 && !buyOrdersPQ.isEmpty() && buyOrdersPQ.peek()[0]>= price) {
                    int[] maxBuy = buyOrdersPQ.peek();
                    int executeAmount = Math.min(amount, maxBuy[1]);

                    amount -= executeAmount;
                    maxBuy[1] -= executeAmount;

                    if(maxBuy[1]==0) {
                        buyOrdersPQ.poll();
                    }
                }
                if(amount>0) {
                    sellOrdersPQ.add(new int[] {price, amount});
                }
            }

        }
        // Summing up the remaining order amounts from both backlogs
        long totalBacklog = 0;
        for(int[] buy: buyOrdersPQ) {
            totalBacklog = (totalBacklog + buy[1]) % MOD;
        }
        for(int[] sell: sellOrdersPQ) {
            totalBacklog = (totalBacklog + sell[1]) % MOD;
        }
        return (int) totalBacklog;
    }
}
