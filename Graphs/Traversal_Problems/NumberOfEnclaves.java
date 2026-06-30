package Traversal_Problems;

public class NumberOfEnclaves {
    int rows;
    int cols;
    public int numEnclaves(int[][] grid) {
        // first I need a visited matrix
        this.rows= grid.length;
        this.cols= grid[0].length;
        boolean[][] visited= new boolean[rows][cols];
        int maxAns=0;
        //then start dfs if not visited
        //if during dfs, it touches the boundary, return, this is not my answer
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    int count[]={0};
                    boolean[] flag={true};
                    dfs(grid, i, j, flag, visited, count);

                    if(flag[0]){
                        maxAns+=count[0];
                    }
                }
            }
        }
        return maxAns;
    }
    void dfs(int[][] grid, int i, int j, boolean[] flag, boolean[][] visited, int[] count){
        if(i<0 || i>=rows || j<0 || j>=cols) return;
        if(visited[i][j] || grid[i][j]==0) return;
        visited[i][j]=true;
        count[0]++;
        //on the boundary
        if(i==0 || j==0 || i==rows-1 || j==cols-1){
            flag[0]=false;
        }
        dfs(grid, i+1, j, flag, visited, count);
        dfs(grid, i-1, j, flag, visited, count);
        dfs(grid, i, j-1, flag, visited, count);
        dfs(grid, i, j+1, flag, visited, count);

    }

}
