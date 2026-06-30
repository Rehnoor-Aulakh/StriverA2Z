package Shortest_Path_Algorithms;
import java.util.*;

public class PathWithMinimumEffort {
    static class Tuple{
        int difference;
        int row;
        int col;
        Tuple(int row, int col, int difference){
            this.row=row;
            this.col=col;
            this.difference=difference;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        int n=heights.length;
        int m=heights[0].length;
        int[][] effort= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                effort[i][j]=Integer.MAX_VALUE;
            }
        }
        effort[0][0]=0;
        PriorityQueue<Tuple> pq= new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                if(o1.difference>o2.difference){
                    return 1;
                }
                return -1;
            }
        });
        int ans= Integer.MAX_VALUE;
        pq.add(new Tuple(0,0,0));
        while(!pq.isEmpty()){
            Tuple top= pq.poll();
            if(top.row==n-1 && top.col==m-1) return top.difference;
            for(int i=0;i<4;i++){
                int row= top.row+drow[i];
                int col= top.col+dcol[i];
                int difference= top.difference;
                if(row>=0 && row<n && col>=0 && col<m){
                    int newEffort=Math.max(difference, Math.abs(heights[row][col]-heights[top.row][top.col]));
                    if(newEffort<effort[row][col]){
                        effort[row][col]= newEffort;
                        pq.add(new Tuple(row,col, newEffort));
                    }
                }
            }
        }
        return 0;
    }
}
