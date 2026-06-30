package Shortest_Path_Algorithms;
import java.util.*;

public class ShortestDistanceInBinaryMaze {
    static class Pair{
        int row;
        int col;
        int distance;
        Pair(int row, int col, int distance){
            this.row= row;
            this.col=col;
            this.distance=distance;
        }
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if( source[0]== destination[0] && source[1]==destination[1]) return 0;
        int drow[]={1,0,-1,0};
        int dcol[]={0,1,0,-1};
        int n= grid.length;
        int m= grid[0].length;
        int dist[][]= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]= Integer.MAX_VALUE;
            }
        }
        dist[source[0]][source[1]]= 0;
        //we have to start from source (i,j) and land at destination (i,j), and return the shortest path
        //simple bfs will suffice because this is unweighted graph
        Queue<Pair> queue= new LinkedList<>();
        queue.add(new Pair(source[0], source[1], 0));
        while(!queue.isEmpty()){
            Pair top= queue.poll();
            //otherwise push the neighbours onto the queue
            for(int i=0;i<4;i++){
                int row= drow[i]+top.row;
                int col= dcol[i]+top.col;
                if(row<n && row>=0 && col<m && col>=0 && grid[row][col]==1){
                    if(top.distance+1<dist[row][col]){
                        if(row==destination[0] && col==destination[1]){
                            return top.distance+1;
                        }
                        queue.add(new Pair(row,col, top.distance+1));
                        dist[row][col]= top.distance+1;
                    }
                }
            }
        }
        return -1;
    }
}
