import java.util.*;

public class FindTheSafestPathInGrid {
    // DIRECTIONS FOR MOVING RIGHT, LEFT, UP, DOWN
    final int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n= grid.size();
        int[][] mat = new int[n][n];
        Queue<int[]> multiSourceQueue = new LinkedList<>();

        // to make modifications and navigation easier, the grid is converted into a 2d array
        for(int i=0; i<n;i++){
            for(int j=0;j<n; j++){
                if(grid.get(i).get(j)==1){
                    multiSourceQueue.add(new int[]{i,j});
                    // mark theif cell with 0
                    mat[i][j] = 0;
                }
                else{
                    // mark empty cell with -1
                    mat[i][j]=-1;
                }
            }
        }
        // CALCULATE SAFENESS FACTOR FOR EACH CELL USING BFS
        while(!multiSourceQueue.isEmpty()){
            int size = multiSourceQueue.size();
            while(size-->0){
                int[] curr = multiSourceQueue.poll();
                // check neighboring cells
                for(int[] d: dir){
                    int di = curr[0] + d[0];
                    int dj = curr[1] + d[1];
                    int val = mat[curr[0]][curr[1]];
                    // check if the neighboring cell is valid and unvisited
                    if(isValidCell(mat, di, dj) && mat[di][dj]==-1){
                        // Update safeness factor and push to the queue
                        mat[di][dj] = val + 1;
                        multiSourceQueue.add(new int[]{di, dj});
                    }
                }
            }
        }

        // BINARY SEARCH FOR MAXIMUM SAFENESS FACTOR
        int start = 0;
        int end = 0;
        int res = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                end = Math.max(end, mat[i][j]);
            }
        }

        while(start<=end){
            int mid = start + (end-start) / 2;
            if(isValidSafeness(mat, mid)){
                res = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return res;
    }
    ///  CHECK IF PATH EXISTS WITH GIVEN MINIMUM SAFENESS VALUE
    private boolean isValidSafeness(int[][] grid, int minSafeness){
        int n = grid.length;
        // check if the source and destination cells satisfy minimum safenes
        if(grid[0][0]<minSafeness || grid[n-1][n-1]<minSafeness) return false;

        Queue<int[]> traversalQueue = new LinkedList<>();
        traversalQueue.add(new int[]{0,0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while(!traversalQueue.isEmpty()){
            int[] curr= traversalQueue.poll();
            // valid path found
            if(curr[0]==n-1 && curr[1]==n-1) return true;
            // check neighboring cells
            for(int[] d: dir){
                int di = curr[0]+ d[0];
                int dj = curr[1]+ d[1];
                if(isValidCell(grid, di, dj) && !visited[di][dj] && grid[di][dj]>=minSafeness){
                    visited[di][dj] = true;
                    traversalQueue.add(new int[]{di, dj});
                }
            }

        }
        return false;
    }
    private boolean isValidCell(int[][] mat, int i, int j){
        int n = mat.length;
        return i>=0 && j>=0 && i<n && j<n;
    }
}
