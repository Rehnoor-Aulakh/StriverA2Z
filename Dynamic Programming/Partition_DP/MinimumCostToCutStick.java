package Partition_DP;
import java.util.*;

public class MinimumCostToCutStick {
    private int f(List<Integer> cuts, int i, int j, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini= (int)1e9;
        // you can have a cut anywhere from i to j
        for(int ind = i; ind<=j; ind++){
            int cost= cuts.get(j+1) - cuts.get(i-1) + f(cuts, i, ind-1, dp) + f(cuts, ind+1, j, dp);
            mini= Math.min(cost, mini);
        }
        return dp[i][j]= mini;
    }
    public int minCostMemoization(int n, List<Integer> cuts) {
        int size= cuts.size();
        Collections.sort(cuts);
        cuts.add(n);
        cuts.add(0,0);
        int[][] dp = new int[size+2][size+2];
        for(int i=0;i<size+2;i++){
            Arrays.fill(dp[i], -1);
        }
        return f(cuts, 1, size, dp);
    }
    // LEETCODE
    public int minCost(int n, int[] cuts) {
        List<Integer> arr= new ArrayList<>();
        int size= cuts.length;
        for(int cut: cuts){
            arr.add(cut);
        }
        Collections.sort(arr);
        arr.add(0,0);
        arr.add(n);
        int[][] dp = new int[size+2][size+2];
        for(int i=0;i<size+2;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(arr,1, size, dp);
    }
    public int minCost(int n, List<Integer> cuts) {
        int size= cuts.size();
        Collections.sort(cuts);
        cuts.add(0,0);
        cuts.add(n);
        int[][] dp = new int[size+2][size+2];
        for(int i= size; i>=1; i--){
            for(int j=i;j<=size;j++){
//                if(i>j) {
//                    dp[i][j]=0;
//                    continue;
//                }
                int mini= (int)1e9;
                // you can have a cut anywhere from i to j
                for(int ind = i; ind<=j; ind++){
                    int cost= cuts.get(j+1) - cuts.get(i-1) + dp[i][ind-1] + dp[ind+1][j];
                    mini= Math.min(cost, mini);
                }
                dp[i][j]= mini;
            }
        }
        return dp[1][size];
    }

    public static void main(String[] args) {
        List<Integer> cuts = new ArrayList<>();
        cuts.add(1);
        cuts.add(3);
        cuts.add(4);
        cuts.add(5);
        MinimumCostToCutStick obj = new MinimumCostToCutStick();
        System.out.println( obj.minCost(7, cuts));
    }
}
