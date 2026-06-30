package Traversal_Problems;

import java.util.*;

public class NumberOfIslands {
    class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row= row;
            this.col=col;
        }
    }
    public int numIslands(char[][] grid) {
        //create a visited matrix
        int rows= grid.length;
        int cols= grid[0].length;
        boolean[][] visited= new boolean[rows][cols];
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(visited[i][j]){
                    continue;
                }
                if(grid[i][j]=='1'){
                    visited[i][j]=true;
                    count++;
                    bfs(visited, i, j, grid);
                }
            }
        }
        return count;
    }

    private void bfs(boolean[][] visited, int i, int j, char[][] grid){
        Queue<Pair> queue= new LinkedList<>();
        //store this pair
        queue.add(new Pair(i,j));
        while(!queue.isEmpty()){
            //pick our a neighbour and add it into the queue
            Pair node= queue.poll();
            int row= node.row;
            int col= node.col;
            //explore all possibilities by adding in the queue
            //left, right, up and down
            if(row-1>=0 && grid[row-1][col]=='1' && !visited[row-1][col]){
                visited[row-1][col]= true;
                queue.add(new Pair(row-1, col));
            }
            if(col-1>=0 && grid[row][col-1]=='1' && !visited[row][col-1]){
                visited[row][col-1]= true;
                queue.add(new Pair(row, col-1));
            }
            if(row+1<grid.length && grid[row+1][col]=='1' && !visited[row+1][col]){
                visited[row+1][col]= true;
                queue.add(new Pair(row+1, col));
            }
            if(col+1<grid[0].length && grid[row][col+1]=='1'&& !visited[row][col+1]){
                visited[row][col+1]= true;
                queue.add(new Pair(row, col+1));
            }
            //diagonals, row-1, col-1, row-1 col+1, row+1 col-1 and row+1 col+1
            // row-1 col-1
            if(row-1>=0 && col-1>=0 && grid[row-1][col-1]=='1' && !visited[row-1][col-1]){
                visited[row-1][col-1]= true;
                queue.add(new Pair(row-1, col-1));
            }
            //row-1 col+1
            if(row-1>=0 && col+1<grid[0].length && grid[row-1][col+1]=='1' && !visited[row-1][col+1]){
                visited[row-1][col+1]= true;
                queue.add(new Pair(row-1, col+1));
            }
            //row+1 col-1
            if(row+1<grid.length && col-1>=0 && grid[row+1][col-1]=='1' && !visited[row+1][col-1]){
                visited[row+1][col-1]= true;
                queue.add(new Pair(row+1, col-1));
            }
            //row+1 col+1
            if(row+1<grid.length && col+1<grid[0].length && grid[row+1][col+1]=='1' && !visited[row+1][col+1]){
                visited[row+1][col+1]= true;
                queue.add(new Pair(row+1, col+1));
            }

        }

    }
}
