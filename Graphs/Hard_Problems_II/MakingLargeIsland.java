package Hard_Problems_II;

import java.util.*;

public class MakingLargeIsland {
    public int largestIsland(int[][] grid) {
        int[] dr = {-1, 0 , 1, 0};
        int[] dc = {0, 1, 0, -1};
        int maxSize= Integer.MIN_VALUE;
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int[][] visited = new int[n][n];
        // STEP 1: CONNECT EXISTING COMPONENTS OF 1s
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    // store its data in disjoint set
                    // find its neighbours
                    int node = (i*n) + j;
                    // up: row-1, col
                    // right: row, col+1
                    // down: row+1, col
                    // left: row, col-1

                    for(int ind=0;ind<4;ind++){
                        int adjacentRow = i+dr[ind];
                        int adjacentCol = j+dc[ind];
                        if(adjacentRow>=0 && adjacentRow<n && adjacentCol>=0 && adjacentCol<n) {
                            if (grid[adjacentRow][adjacentCol] == 1) {
                                int adjacentNode = (adjacentRow*n) + adjacentCol;
                                ds.unionBySize(node, adjacentNode);
                            }
                        }

                    }
                }
            }
        }
        // STEP2 : EVALUATE FLIPPING OF EVERY SINGLE 0
        // ITERATE OVER THE 0'S THAT ARE UNVISITED
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 && visited[i][j]==0){
                    // mark it visited
                    visited[i][j]=1;
                    int node = (i*n)+j;
                    // check its neighbours that are 1
                    // up: row-1, col
                    // right: row, col+1
                    // down: row+1, col
                    // left: row, col-1
                    int ulp=-1;
                    Set<Integer> set= new HashSet<>();
                    for(int ind = 0; ind<4; ind++){
                        int adjacentRow= i + dr[ind];
                        int adjacentCol = j+ dc[ind];
                        if(adjacentRow>=0 && adjacentRow<n && adjacentCol>=0 && adjacentCol<n){
                            if(grid[adjacentRow][adjacentCol]==1){
                                int adjacentNode =(adjacentRow*n) + adjacentCol;
                                // you need to do union by size of node and adjacentNode
                                // now store the ultimate parent of node
                                ulp = ds.findUPar(adjacentNode);
                                set.add(ulp);
                            }
                        }
                    }
                    // after iterating the neighbours, make the candidate maxSize
                    int size=1;
                    for(int s: set){
                        size+=ds.size.get(s);
                    }
                    maxSize= Math.max(maxSize, size);

                }
            }
        }
        // check that prebuild ones dont contain maxSize
        for(int i=0;i<n*n;i++){
            maxSize = Math.max(maxSize, ds.size.get(i));
        }
        return maxSize;
    }
}
