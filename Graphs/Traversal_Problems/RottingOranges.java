package Traversal_Problems;
import java.util.*;

public class RottingOranges {
    static class Pair{
        int row;
        int col;
        int time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int visited[][] = new int[n][m];
        int freshOranges= 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                else{
                    visited[i][j]=0;
                }
                if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        int time= 0;
        int drow[]= {-1,0,1,0};
        int dcol[]= {0,1,0,-1};
        int count=0;
        //bfs
        while(!queue.isEmpty()){
            Pair top = queue.poll();
            int row= top.row;
            int col= top.col;
            int tm= top.time;
            //pick the maximum of running time, or the time at which this was added
            time = Math.max(tm, time);
            for(int i=0;i<4;i++){
                int nrow= row+drow[i];
                int ncol= col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m
                && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    queue.add(new Pair(nrow, ncol, time+1));
                    visited[nrow][ncol]=2;
                    count++;
                }
            }
        }
        if(freshOranges!=count) return -1;
        return time;

    }
}
