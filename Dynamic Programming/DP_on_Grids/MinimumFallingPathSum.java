package DP_on_Grids;
import java.util.*;
public class MinimumFallingPathSum {
    private int f(int[][] matrix, int i, int j, int[][] dp){
        if(j<0 || i<0 || j>=matrix[0].length) return Integer.MAX_VALUE;
        if(i==0) return matrix[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]= matrix[i][j] + Math.min(f(matrix, i-1, j, dp), Math.min(f(matrix, i-1,j-1, dp), f(matrix, i-1, j+1, dp)));
        return dp[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m= matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i=0; i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        int mini= Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            mini= Math.min(mini, f(matrix, n-1, j, dp));
        }
        return mini;
    }
    public int minFallingPathSumTabulation(int[][] matrix){
        int n= matrix.length;
        int m = matrix[0].length;
        int[][] dp= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    dp[i][j]=matrix[i][j];
                }
                else{
                    int up = dp[i-1][j];

                    int left = (j > 0) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                    int right = (j < m-1) ? dp[i-1][j+1] : Integer.MAX_VALUE;

                    dp[i][j] = matrix[i][j] + Math.min(up, Math.min(left, right));
                }

            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            min= Math.min(min, dp[n-1][j]);
        }
        return min;
    }
    public int minFallingPathSumSpaceOptimized(int[][] matrix){
        int n= matrix.length;
        int m = matrix[0].length;
        int[] prev= new int[m];
        int[] temp= new int [m];
        for(int i=0;i<n;i++){
            temp= new int[m];
            for(int j=0;j<m;j++){
                if(i==0){
                    prev[j]=matrix[0][j];
                }
                else{
                    int up = prev[j];

                    int left = (j > 0) ? prev[j-1] : Integer.MAX_VALUE;
                    int right = (j < m-1) ? prev[j+1] : Integer.MAX_VALUE;

                    prev[j] = matrix[i][j] + Math.min(up, Math.min(left, right));
                }
            }
            prev= temp;
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            min= Math.min(min, prev[j]);
        }
        return min;
    }
}
