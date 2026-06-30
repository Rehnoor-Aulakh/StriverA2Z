package DP_on_Grids;
import java.util.*;
public class UniquePathsII {
    private int f(int i, int j, int[][] matrix, int[][] dp){
        //base case
        if(i==0 && j==0 && matrix[i][j]==0) return 1;
        if((i==0 && j==0) || i<0 || j<0) return 0;
        if(matrix[i][j]==1){
            //there is an obstacle, hence this path is a waste
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j] = f(i-1,j, matrix, dp)+f(i, j-1, matrix, dp);
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] matrix) {
        int n= matrix.length;
        int m= matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        dp[0][0]=1;
        return f(n-1, m-1, matrix,dp);
    }
    public int uniquePathsWithObstaclesTabulation(int[][] matrix){
        int n= matrix.length;
        int m= matrix[0].length;
        if(matrix[0][0]==1) return 0;
        int[][] dp= new int[n][m];
        dp[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) continue;
                // if current position has a stone return 0
                if(matrix[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                int left=0;
                int up=0;
                if(j-1>=0){
                    left= dp[i][j-1];
                }
                if(i-1>=0){
                    up= dp[i-1][j];
                }
                dp[i][j]= left+up;
            }
        }
        return dp[n-1][m-1];
    }
    public int uniquePathsSpaceOptimized(int[][] matrix){
        int n= matrix.length;
        int m= matrix[0].length;
        if(matrix[0][0]==1) return 0;
        int[] dp= new int[m];
        int[] temp= new int[m];
        for(int i=0;i<n;i++){
            temp= new int[m];
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1){
                    temp[j]=0;
                }
                else if(i==0 && j==0){
                    temp[j]=1;
                }
                else{
                    if(j-1<0){
                        temp[j]=dp[j];
                        continue;
                    }
                    temp[j]= temp[j-1]+ dp[j];
                }

            }
            dp=temp;
        }
        return temp[m-1];
    }
}
