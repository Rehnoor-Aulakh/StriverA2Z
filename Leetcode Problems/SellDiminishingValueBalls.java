import java.util.Arrays;

public class SellDiminishingValueBalls {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int n = inventory.length;
        long width = 1;
        long greatest, nextGreatest;
        int MOD = 1000000007;
        long ans = 0;
        greatest= inventory[n-1];
        for(int i= n-1; i>=0 && orders>0; i--){
            nextGreatest = (i>0)?inventory[i-1]:0;
            if(greatest==nextGreatest){
                width++;
                continue;
            }
            long diff=  (greatest-nextGreatest);
            long availableInTier = width*diff;
            if(orders>= availableInTier){
                // we can afford the entire horizontal tier block
                long sumForOneCol= ((greatest*(greatest+1))/2 - (nextGreatest*(nextGreatest+1))/2);
                ans = (ans+(sumForOneCol%MOD)*width)%MOD;

                orders-= (int) availableInTier;
                greatest = nextGreatest;
            } else{
                // orders is smaller than available tier
                long completeRows = orders/width;
                long remainderItems = orders % width;

                long newNext = greatest - completeRows;
                long sumForOneColumn = ((greatest * (greatest + 1)) / 2) - ((newNext * (newNext + 1)) / 2);
                ans = (ans + (sumForOneColumn % MOD) * width) % MOD;

                // Sell the remaining leftover items at the next immediate price boundary
                ans = (ans + remainderItems * newNext) % MOD;


                orders = 0;
            }
            width++;
        }
        return (int) ans;
    }


}
