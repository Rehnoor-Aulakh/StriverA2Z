import java.util.*;

class Solution{
    public List<String> findPath(int[][] grid) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        if(grid[0][0]==0) return ans;
        backtrack(grid, ans, sb, 0, 0);
        return ans;
    }
    private void backtrack(int[][] grid, List<String> ans, StringBuilder sb, int row, int col){
        if(row==grid.length-1 && col==grid[0].length-1 && grid[row][col]==1){
            ans.add(new String(sb));
            return;
        }
        if(row>=grid.length || col>=grid[0].length || row<0 || col<0 || grid[row][col]==0) return;
        //otherwise explore all paths
        if(grid[row][col]==1){
            //we also need to mark it as visited, so that it does not traverse this again
            grid[row][col]=-1;
            //go down,right,left,up
            sb.append("D");
            backtrack(grid, ans, sb, row+1, col);
            sb.deleteCharAt(sb.length()-1);
            sb.append("R");
            backtrack(grid, ans, sb, row, col+1);
            sb.deleteCharAt(sb.length()-1);
            sb.append("L");
            backtrack(grid, ans, sb, row, col-1);
            sb.deleteCharAt(sb.length()-1);
            sb.append("U");
            backtrack(grid, ans, sb, row-1, col);
            sb.deleteCharAt(sb.length()-1);
            grid[row][col]=1;
        }
        
    }
}

public class RatInAMaze{
    public static void main(String[] args) {
        int[][] grid={{1, 0, 0, 0},{1, 1, 0, 1},{1, 1, 0, 0},{0, 1, 1, 1}};
        Solution s = new Solution();
        System.out.println(s.findPath(grid));
    }
}