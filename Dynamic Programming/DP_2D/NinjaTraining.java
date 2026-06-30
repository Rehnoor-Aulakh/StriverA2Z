package DP_2D;
import java.util.*;

public class NinjaTraining {
    private int f(int[][] matrix, int last, int day, int[][] dp){
        //base case- for day 0, just select the largest one that was not used
        if(day==0){
            int maxi=0;
            for(int task=0;task<3;task++){
                if(task!= last){
                    maxi= Math.max(maxi, matrix[day][task]);
                }
            }
            return maxi;
        }
        if(dp[day][last]!=-1) return dp[day][last];
        // iterate over the tasks and recursive calls
        int maxi= 0;
        for(int task=0;task<3;task++){
            if(task!=last){
                int point= matrix[day][task] + f(matrix, task, day-1, dp);
                maxi= Math.max(point, maxi);
            }
        }
        dp[day][last]= maxi;
        return maxi;
    }
    public int ninjaTraining(int[][] matrix) {
        int n= matrix.length;
        int[][] dp = new int[n][4];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return f(matrix, 3, matrix.length-1, dp);
    }
    public int ninjaTrainingTabulation(int[][] matrix) {
        int n= matrix.length;
        int[][] dp = new int[n][4];
        dp[0][0]= Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1]= Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2]= Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3]= Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        for(int day=1 ; day<n; day++){
            for(int last= 0; last< 4; last++){
                dp[day][last]=0;
                for(int task= 0; task< 3; task++){
                    if(task!=last){
                        int point= matrix[day][task] + dp[day-1][task];
                        dp[day][last]= Math.max(point, dp[day][last]);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
    public int ninjaTrainingSpaceOptimization(int[][] matrix) {
        int n= matrix.length;
        int[] prev = new int[4];
        prev[0]= Math.max(matrix[0][1], matrix[0][2]);
        prev[1]= Math.max(matrix[0][0], matrix[0][2]);
        prev[2]= Math.max(matrix[0][0], matrix[0][1]);
        prev[3]= Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        for(int day=1 ; day<n; day++){
            int[] temp = new int[4];
            for(int last= 0; last< 4; last++){
                temp[last]=0;
                for(int task= 0; task< 3; task++){
                    if(task!=last){
                        temp[last]= Math.max(matrix[day][task] + prev[task], temp[last]);
                    }
                }
            }
            prev=temp;
        }
        return prev[3];
    }
}
