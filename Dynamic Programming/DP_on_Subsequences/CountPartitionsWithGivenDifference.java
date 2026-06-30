import java.util.Arrays;

public class CountPartitionsWithGivenDifference {
    private static final int MOD= 1000000007;
    private static int f(int[] arr, int i, int target, int[][] dp){
        //handled 0 case
        if(i==0){
            if(target == 0 && arr[0]==0) return 2;
            if(target ==0 || arr[0]==target) return 1;
            return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int dontInclude =  f(arr, i-1, target, dp);
        int include = 0;
        if(target-arr[i]>=0){
            include =  f(arr, i-1, target-arr[i], dp);
        }
        dp[i][target]= (dontInclude + include)%MOD;
        return dp[i][target];
    }
    public static int countPartitionsMemoization(int n, int diff, int[] arr) {
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum+=arr[i];
        }
        if((totalSum-diff)%2!=0 || (totalSum-diff)<0) return 0;
        int target= (totalSum - diff)/2;
        int[][] dp= new int[n][target+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(arr, n-1, target, dp);
    }
    public int countPartitionsTabulation(int n, int diff, int[] arr) {
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum+=arr[i];
        }
        if((totalSum-diff)%2!=0 || (totalSum-diff)<0) return 0;
        int target= (totalSum - diff)/2;
        int[][] dp= new int[n][target+1];
        // handle base case
        if(arr[0]==0){
            dp[0][0]=2;
        }
        else{
            dp[0][0]=1;
        }
        if(arr[0] !=0 && target-arr[0]>=0){
            dp[0][arr[0]]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0; j<=target; j++){
                int dontInclude = dp[i-1][j];
                int include = 0;
                if(j-arr[i]>=0){
                    include = dp[i-1][j-arr[i]];
                }
                dp[i][j] = (include + dontInclude)%1000000007;
            }
        }
        return dp[n-1][target];

    }

}
