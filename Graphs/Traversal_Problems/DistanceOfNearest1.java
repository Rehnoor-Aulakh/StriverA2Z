package Traversal_Problems;

import java.util.*;

class Solution {
    int[] drow;
    int[] dcol;
    int n;
    int m;
    static class Pair{
        int row;
        int col;
        int dist;
        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist=dist;
        }
    }
    Solution(){
        drow = new int[]{-1,0,1,0};
        dcol= new int[]{0,1,0,-1};
    }
    public int[][] nearest(int[][] grid) {
        this.n= grid.length;
        this.m = grid[0].length;
        int ans[][]= new int[n][m];
        boolean[][] visited= new boolean[n][m];
        Queue<Pair> queue= new LinkedList<>();
        //push all ones into queue
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    queue.add(new Pair(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        //bfs
        while(!queue.isEmpty()){
            Pair top= queue.poll();
            int row= top.row;
            int col= top.col;
            int dist= top.dist;
            ans[row][col]= dist;
            for(int i=0;i<4;i++){
                int nr= row+ drow[i];
                int nc= col+dcol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    queue.add(new Pair(nr,nc,dist+1));
                }
            }
        }
        return ans;
    }
}
