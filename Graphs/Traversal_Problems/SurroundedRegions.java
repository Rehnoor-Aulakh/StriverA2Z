package Traversal_Problems;

class Solution1{
    int n;
    int m;
    int drow[];
    int dcol[];
    Solution1(){
        drow= new int[]{-1,0,1,0};
        dcol = new int[]{0,1,0,-1};
    }
    public char[][] fill(char[][] board) {
        this.n= board.length;
        this.m= board[0].length;
        //now iterate the boundary points and find 'O'
        for(int col=0;col<m;col++){
            int row=0;
            if(board[row][col]=='O'){
                dfs(board, row, col);
            }
            row= n-1;
            if(board[row][col]=='O'){
                dfs(board, row, col);
            }
        }
        for(int row=0;row<n;row++){
            int col= m-1;
            if(board[row][col]=='O'){
                dfs(board,row,col);
            }
            col=0;
            if(board[row][col]=='O'){
                dfs(board,row,col);
            }
        }
        //convert remaing ? to X
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
        return board;
    }
    private void dfs(char[][] board, int row, int col){
        if(row < 0 || col < 0 || row >= n || col >= m || board[row][col] != 'O'){
            return;
        }
        board[row][col] = '#';
        for(int i = 0; i < 4; i++){
            dfs(board, row + drow[i], col + dcol[i]);
        }
    }
}
