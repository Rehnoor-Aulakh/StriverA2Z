import java.util.Arrays;

public class SubsetSumEqualsTarget {
    static boolean f(int[] arr, int target, int i, int[][] dp){
        if(target==0) return true;
        if(i==0) return arr[0]==target;
        //out of bound case
        if(i<0) return false;
        //if the result is stored already, return that only
        if(dp[i][target]!=-1) return dp[i][target] == 1;
        //otherwise include or dont include
        boolean dontInclude= f(arr, target, i-1, dp);
        boolean include= false;
        if(target >= arr[i]){
            include=  f(arr, target - arr[i], i - 1, dp);
        }
        dp[i][target] = (dontInclude || include) ?1:0;
        return dp[i][target] == 1;
    }
    public static boolean isSubsetSumMemoization(int[] arr, int target) {
        int n= arr.length;
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }
        return f(arr, target, n-1, dp);
    }
    public static boolean isSubsetSumTabulation(int[] arr, int target){
        int n = arr.length;
        boolean[][]dp = new boolean[n][target+1];
        if(arr[0] <= target){
            dp[0][arr[0]] = true;
        }
        for(int i=0;i<n;i++){
            dp[i][0]= true;
        }
        for(int i=1;i<n;i++){
            for(int t=1; t<=target;t++){
                boolean dontInclude= dp[i-1][t];
                boolean include= false;
                if(t >= arr[i]){
                    include=  dp[i-1][t-arr[i]];
                }
                dp[i][t] = (dontInclude || include);
            }
        }
        return dp[n-1][target];
    }
    public static boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[] prev= new boolean[target+1];
        boolean[] curr= new boolean[target+1];
        prev[0]= true;
        curr[0]= true;

        if(arr[0] <= target){
            prev[arr[0]] = true;
        }

        for(int i=1;i<n;i++){
            curr= new boolean[target+1];
            curr[0]=true;
            for(int t=1; t<=target;t++){
                boolean dontInclude= prev[t];
                boolean include= false;
                if(t >= arr[i]){
                    include=  prev[t-arr[i]];
                }
                curr[t] = (dontInclude || include);
            }
            prev= curr;
        }
        return prev[target];
    }

    static void main() {

        System.out.println(isSubsetSum(new int[]{1, 2, 7, 3}, 6));
    }
}
