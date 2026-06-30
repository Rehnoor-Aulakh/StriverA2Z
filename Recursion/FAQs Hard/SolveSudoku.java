class Solution{
    public void solveSudoku(char[][] board) {
        //try all possible combinations 
        //go row by row and try from 1 to 9 by using backtracking
        dfs(board,0,0);

    }
    private boolean dfs(char[][] board, int row, int col){
        if(row==9) return true;
        if(col==9) return dfs(board,row+1,0);
        if(board[row][col]!='.'){
            return dfs(board,row,col+1);
        }
        //in the i,j position, try putting 1 to 9, check which satisfies and recursively call for the next
        for(char c='1' ; c <= '9' ; c++){
            if(isSafe(board, row, col, c)){
                board[row][col]=c;
                if(dfs(board,row,col+1)){
                    return true;
                }
                //backtrack
                board[row][col]='.';
            }
        }
        return false;
    }
    private boolean isSafe(char[][] board, int row, int col, char c){
        //check row
        if(checkRow(board, row, c)){
            if(checkCol(board, col, c)){
                if(checkBox(board, row, col, c)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkRow(char[][] board, int row, char c){
        // I need to check the row'th row of board, to find if c exists
        for(int i=0;i<9;i++){
            if(board[row][i]==c) return false;
        }
        return true;
    }
    private boolean checkCol(char[][] board, int col, char c){
        for(int i=0;i<9;i++){
            if(board[i][col]==c) return false;
        }
        return true;
    }
    private boolean checkBox(char[][] board, int row, int col, char c){
        int startRow=row-(row%3);
        int startCol=col-(col%3);
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(board[i][j]==c) return false;
            }
        }
        return true;
    }
}

public class SolveSudoku{
    private static void printMatrix(char[][] board){
        for(int i=0;i<board.length;i++){
            for( int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        printMatrix(board);
        Solution s = new Solution();
        s.solveSudoku(board);
        printMatrix(board);
        
    
    }
}