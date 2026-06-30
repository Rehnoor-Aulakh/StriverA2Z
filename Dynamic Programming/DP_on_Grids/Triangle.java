package DP_on_Grids;
import java.util.*;

public class Triangle {
    private int f(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        if (i == triangle.size() - 1) return triangle.get(i).get(j);
        if (dp[i][j] != -1) return dp[i][j];

        int down = f(triangle, i + 1, j, dp);
        int diagonal = f(triangle, i + 1, j + 1, dp);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return f(triangle, 0, 0, dp);
    }
    public int minimumTotalTabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        //base case
        for(int i=0;i<n;i++){
            dp[n-1][i]= triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j]= triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
    public int minimumTotalSpaceOptimized(List<List<Integer>> triangle){
        int n= triangle.size();
        int[] prev= new int[n];
        int[] temp= new int[n];
        for(int i=0;i<n;i++){
            prev[i]= triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0; i--){
            temp= new int[n];
            for(int j=0;j<=i;j++){
                temp[j]= triangle.get(i).get(j) + Math.min(prev[j], prev[j+1]);
            }
            prev= temp;
        }
        return prev[0];
    }
}