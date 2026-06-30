import java.util.*;

class Solution{
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board= new ArrayList<>();
        for(int i=0;i<n;i++){
            board.add(".".repeat(n));
        }
        int i=0;
        placeQueen(board,i,n,ans);

        return ans;
    }
    private void placeQueen(List<String> board, int row, int n,List<List<String>> ans){
        if(row==n){
            //we have reached the end, completed all rows
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(board,row,col,n)){
                char[] rowArr= board.get(row).toCharArray();
                rowArr[col]='Q';
                board.set(row, new String(rowArr));
                placeQueen(board, row+1, n, ans);
                //backtrack
                rowArr[col]='.';
                board.set(row, new String(rowArr));
            }
        }
    }
    private boolean isSafe(List<String> board, int row, int col,int n){
        int r=row;
        int c=col;
        while(r>=0){ //top check
            if(board.get(r).charAt(col)=='Q'){
                return false;
            }
            r=r-1;
        }
        r=row;
        while(r>=0 && c<n){
            if(board.get(r).charAt(c)=='Q'){
                return false;
            }
            r--;c++;
        }
        r=row;c=col;
        while(r>=0 && c>=0){
            if(board.get(r).charAt(c)=='Q'){
                return false;
            }
            r--;c--;
        }
        return true;
    }
}

public class NQueen{
    public static void main(String[] args) {
        
        int n=4;
        Solution s = new Solution();
        System.out.println(s.solveNQueens(n));
    }
}