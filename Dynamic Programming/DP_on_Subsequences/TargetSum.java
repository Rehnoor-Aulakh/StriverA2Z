import java.util.Arrays;

public class TargetSum {
    private final int MOD = 1000000007;
    private int f(int[] arr, int i, int target, int[][] dp){
        if(i==0){
            if(target==0 && arr[0]==0) return 2;
            if(target ==0 || target==arr[0]) return 1;
            return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int dontInclude= f(arr, i-1, target, dp);
        int include =0;
        if(target-arr[i]>=0){
            include = f(arr, i-1, target-arr[i], dp);
        }
        return dp[i][target]=(include+dontInclude)%MOD;
    }
    private int countPartitionGivenDifference(int[] arr, int diff, int n){
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum+=arr[i];
        }
        if((totalSum-diff)%2==0 && (totalSum-diff)>=0){
            int target = (totalSum-diff)/2;
            int[][] dp = new int[n][target+1];
            for(int i=0;i<n;i++){
                Arrays.fill(dp[i],-1);

            }
            return f(arr, n-1, target, dp);
        }
        else return 0;
    }
    public int targetSum(int n, int target, int[] nums) {
        return countPartitionGivenDifference(nums, target, n);

    }
}
