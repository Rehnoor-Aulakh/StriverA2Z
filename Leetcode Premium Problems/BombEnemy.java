public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int maxEnemies = 0;

        int rowHits = 0;
        int[] colHits = new int[cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols; j++){
                // recompute row hits only if we are at first column or we hit a wall
                if(j==0 || grid[i][j-1]=='W') {
                    rowHits = 0;
                    int k = j;
                    while (k < cols && grid[i][k] != 'W') {
                        if (grid[i][k] == 'E') {
                            rowHits++;
                        }
                        k++;
                    }
                }
                    // recompute colHits[j], only if we are at the first row, or
                    // just below a wall
                    if(i==0 || grid[i-1][j]=='W'){
                        colHits[j]=0;
                        int k = i;
                        while(k<rows && grid[k][j]!='W'){
                            // for all the rows, iterate the jth column and count colHits
                            if(grid[k][j]=='E'){
                                colHits[j]++;
                            }
                            k++;
                        }
                    }
                    if(grid[i][j]=='0'){
                        maxEnemies = Math.max(maxEnemies, rowHits + colHits[j]);
                    }
                }
            }
        return maxEnemies;
    }
}
