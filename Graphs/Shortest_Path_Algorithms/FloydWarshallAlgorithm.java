package Shortest_Path_Algorithms;
import java.util.*;

public class FloydWarshallAlgorithm {
    public void shortestDistance(int[][] matrix) {
        //brute force to find the shortest path from every node to every node to every other node
        int n= matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1){
                    //unreachable node, mark it as infinity
                    matrix[i][j]=(int)(1e9);
                }
                if(i==j) matrix[i][j]=0;
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==(int)(1e9)){
                    //unreachable node, mark it as infinity
                    matrix[i][j]=-1;
                }
                if(i==j) matrix[i][j]=0;
            }
        }

        //what if there is a negative cycle
        for(int i=0; i<n; i++){
            if(matrix[i][i]<0){
                //return negative cycle
            }
        }
    }
}
