package SubsequencePatternProblems;

import java.util.Arrays;

public class CountAllSubsequencesWithSumK {
    // this can be converted to 2D dp because i and k are changing, and we can store the intermediate states -> repeating subproblems
    private static int f(int[] nums, int k, int i, int[][] dp) {
        if(k==0) return 1;
        if(k<0) return 0;
        if(i<0 || i>=nums.length) return 0;
        if(dp[k][i]!=-1) return dp[k][i];
        // otherwise, we have to include and dont include
        int include= f(nums, k-nums[i], i+1, dp);
        int dontInclude = f(nums, k, i+1, dp);
        return dp[k][i] = dontInclude + include;
    }
    public static int countSubsequenceWithTargetSumMemoization(int[] nums, int k) {
        // since we have to count all subsequences, this is include dont include question
        int[][] dp = new int[k+1][nums.length+1];
        for(int i=0; i<=k; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(nums, k, 0, dp);
    }
    // Tabulation
    public static int countSubsequenceWithTargetSum(int[] nums, int k) {
        // since we have to count all subsequences, this is include dont include question
        int n = nums.length;
        int[][] dp = new int[k+1][n+1];
        // for k==0 , mark the array as all ones, that is the first row
        for(int i=0; i<=n; i++ ) {
            dp[0][i] = 1;
        }
        for(int target=1; target<=k; target++) {
            for(int j=nums.length-1; j>=0; j--) {
                int include = 0;
                if(target-nums[j] >= 0){

                    include= dp[target-nums[j]][j+1];

                }
                int dontInclude = dp[target][j+1];
                dp[target][j] = include + dontInclude;
            }
        }
        return dp[k][0];
    }

    public static void main() {
        System.out.println(countSubsequenceWithTargetSum(new int[]{4,9,2,5,1},10));
    }
}
