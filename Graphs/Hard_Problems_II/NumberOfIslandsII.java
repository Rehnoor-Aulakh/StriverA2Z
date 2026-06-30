package Hard_Problems_II;
import java.util.*;

public class NumberOfIslandsII {
    public List<Integer> numOfIslands(int n, int m, int[][] A) {
        DisjointSet ds = new DisjointSet(n*m);
        int[][] visited= new int[n][m];
        // count is NUMBER OF CONNECTED COMPONENTS
        int count=0;
        List<Integer> ans = new ArrayList<>();
        for(int[] it: A){
            int row= it[0];
            int col= it[1];
            if(visited[row][col]==1){
                ans.add(count);
                // if this is already visited, do nothing
                continue;
            }
            visited[row][col]=1;
            count++;
            // up: row-1, col
            // right: row, col+1
            // down: row+1, col
            // left: row, col-1
            int[] dr = {-1, 0 , 1, 0};
            int[] dc = {0, 1, 0, -1};
            for(int ind=0;ind<4; ind++){
                int adjacentRow = row + dr[ind];
                int adjacentCol = col + dc[ind];
                if(adjacentRow>=0 && adjacentRow<n && adjacentCol>=0 && adjacentCol<m){
                    // if the adjacent one is an island
                    if(visited[adjacentRow][adjacentCol]==1){
                        int nodeNo = row*m + col;
                        int adjacentNodeNo = adjacentRow*m + adjacentCol;
                        if(ds.findUPar(nodeNo)!= ds.findUPar(adjacentNodeNo)){
                            // they are not connected, so we have to connect them
                            count--;
                            ds.unionBySize(nodeNo, adjacentNodeNo);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
