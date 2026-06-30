import java.util.Arrays;

public class ParitionMinDifferenceSubset {
    private boolean f(int[] arr, int target, int i, int[][] dp){
        if(target==0) return true;
        if(i==0) return arr[0]==target;
        if(i<0) return false;
        //if the result is already calculated, no need to calculate it again
        if(dp[i][target]!=-1) return (dp[i][target]==1);
        // otherwise play include dont include
        boolean dontInclude= f(arr, target, i-1, dp);
        boolean include = false;
        if(target-arr[i]>=0){
            //then only include, otherwise, the target would become negative, and we dont have negative numbers
            include = f(arr, target-arr[i], i-1, dp);
        }
        dp[i][target]= (include || dontInclude) ? 1 : 0;
        return include || dontInclude;
    }
    public int minDifferenceMemoization(int[] arr, int n) {
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum+=arr[i];
        }
        int[][] dp = new int[n+1][totalSum+1];
        for(int i =0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        // calculate the subset sum for each possible sum from 0 to totalSum
        for(int i=0;i<=totalSum; i++){
            f(arr, i, n-1, dp);
        }
        //now that our dp table is ready, we can go on to find sum1
        //pick for the last row of dp table, wherever the value is true
        int mini = Integer.MAX_VALUE;
        for(int target=0;target<=totalSum;target++){
            if(dp[n-1][target]==1){
                int sum1= target;
                int sum2= totalSum-target;
                mini= Math.min(Math.abs(sum1-sum2), mini);
            }
        }
        return mini;
    }
    public int minDifferenceTabulation(int[] arr, int n) {
        int totalSum  = 0;
        for(int i=0;i<n;i++){
            totalSum += arr[i];
        }

        boolean[][] dp = new boolean[n][totalSum+1];
        // base case
        for(int i=0;i<=totalSum;i++){
            dp[i][0]=true;
        }
        dp[0][arr[0]]= true;
        // fill the dp table using bottom-up approach
        for(int i=1; i<n;i++){
            for(int target=0; target<= totalSum; target++){
                boolean dontInclude = dp[i-1][target];
                boolean include = false;
                if(target>=arr[i]){
                    include= dp[i-1][target-arr[i]];
                }
                dp[i][target] = include || dontInclude;
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<=totalSum;i++){
            if(dp[n-1][i]){
                int sum1= i;
                int sum2= totalSum-i;
                mini = Math.min(mini, Math.abs(sum1-sum2));
            }
        }
        return mini;
    }
    public int minDifference(int[] arr, int n) {
        int totalSum  = 0;
        for(int i=0;i<n;i++){
            totalSum += arr[i];
        }
        boolean[] prev= new boolean[totalSum+1];
        boolean[] curr= new boolean[totalSum+1];

        // base case
        prev[0]=true;
        curr[0]= true;
        prev[arr[0]]= true;
        // fill the dp table using bottom-up approach
        for(int i=1; i<n;i++){
            for(int target=0; target<= totalSum; target++){
                boolean dontInclude = prev[target];
                boolean include = false;
                if(target>=arr[i]){
                    include= prev[target-arr[i]];
                }
                curr[target] = include || dontInclude;
            }
            prev=curr;
            curr= new boolean[totalSum+1];
            curr[0]=true;
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<=totalSum;i++){
            if(prev[i]){
                int sum1= i;
                int sum2= totalSum-i;
                mini = Math.min(mini, Math.abs(sum1-sum2));
            }
        }
        return mini;
    }
}
