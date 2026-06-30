package Traversal_Problems;
import java.util.*;

public class NumberOfDistinctIslands {
    int n;
    int m;
    public int countDistinctIslands(int[][] grid) {
        Set<List<List<Integer>>> set = new HashSet<>();
        this.n= grid.length;
        this.m= grid[0].length;
        boolean[][] visited= new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    //start dfs
                    List<List<Integer>> curr= new ArrayList<>();
                    dfs(grid, visited, curr, i,j, i,j);
                    set.add(curr);
                }
            }
        }
        return set.size();
    }
    private void dfs(int[][] grid, boolean[][] visited, List<List<Integer>> curr, int row, int col, int baseRow, int baseCol){
        //check indices
        if(row<0 || row>=n || col<0 || col>=m || visited[row][col] || grid[row][col]==0) return;
        visited[row][col]=true;
        //store normalized row, col
        List<Integer> first= new ArrayList<>();
        first.add(row-baseRow);
        first.add(col-baseCol);
        curr.add(first);
        //go right
        dfs(grid, visited, curr, row, col+1 , baseRow, baseCol);
        //go down
        dfs(grid, visited, curr, row+1, col, baseRow, baseCol);
        //go left
        dfs(grid, visited, curr, row, col-1, baseRow, baseCol);
        //go up
        dfs(grid, visited, curr, row-1,col, baseRow, baseCol);

    }
}
