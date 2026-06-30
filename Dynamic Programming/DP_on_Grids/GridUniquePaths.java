package DP_on_Grids;
import java.util.*;

public class GridUniquePaths {
    private static int f(int i, int j, int[][] dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]= f(i-1, j, dp) + f(i, j-1, dp);
        return dp[i][j];
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m ;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(m-1, n-1, dp);
    }
    public static int uniquePathsTabulation(int m, int n){
        int[][] dp= new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                int left=0, up=0;
                if((i-1)>=0){
                    up= dp[i-1][j];
                }
                if((j-1)>=0){
                    left= dp[i][j-1];
                }
                dp[i][j]= left+up;
            }
        }
        return dp[m-1][n-1];
    }
    public static int uniquePathsSpaceOptimized(int m, int n){
        int[] dp= new int[n];
        int[] temp= new int[n];
        for(int i=0;i<m;i++){
            temp= new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    temp[j]=1;
                }
                else{
                    if(j-1<0){
                        temp[j]= dp[j];
                    }
                    else{
                        temp[j]= dp[j]+ temp[j-1];
                    }
                }
            }
            dp=temp;
        }
        return temp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
}
