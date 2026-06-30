import java.util.Arrays;

public class CountSubsetsWithSumK {
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

    public static int perfectSumMemoization(int[] arr, int K) {
        int n = arr.length;
        int[][] dp = new int[n][K+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(arr, n-1, K, dp);
    }

    public static int perfectSumTabulation(int[] arr, int K){
        int n = arr.length;
        int[][] dp = new int[n][K+1];
        // make the first column as 1
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        // and for the first row, where index is arr[0], make it 1
        if(arr[0]<=K){
            dp[0][arr[0]]=1;
        }
        //now start the iteration
        for(int i=1;i<n;i++){
            for(int target = 1; target <= K; target++){
                int dontInclude = dp[i-1][target];
                int include = 0;
                if(target -arr[i]>=0){
                    include = dp[i-1][target-arr[i]];
                }
                dp[i][target] = dontInclude + include;
            }
        }
        return dp[n-1][K];
    }
    public static int perfectSum(int[] arr, int K){
        int n= arr.length;
        int prev[]= new int[K+1];
        int curr[]= new int[K+1];
        // make target 0 as 1
        prev[0]= 1;
        curr[0]= 1;
        if(arr[0]<=K){
            prev[arr[0]]=1;
        }
        for(int i = 1; i < n;i++){
            for(int target = 1; target <=K; target++){
                int dontInclude = prev[target];
                int include = 0;
                if(target-arr[i]>=0){
                    include = prev[target-arr[i]];
                }
                curr[target] = (include + dontInclude)%MOD;
            }
            prev= curr;
            curr= new int[K+1];
            curr[0]=1;
        }
        return prev[K];

    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,3};
        System.out.println(perfectSum(arr, 3));
    }

}
