class Solution{
    int rows;
    int cols;
    private  boolean search(char[][] board, String word, int i, int j, int index){
        if(index==word.length()) return true;

        if(i<0 || j<0 || i>=rows || j>=cols || board[i][j]!=word.charAt(index)) return false;

        //mark visited
        char temp=board[i][j];
        board[i][j]='#';
        //recursive calls, left, right,up,down
        boolean found= search(board, word, i+1, j, index+1) || search(board, word, i, j+1, index+1) || search(board, word, i-1, j, index+1) || search(board, word, i, j-1, index+1);

        //restore
        board[i][j]=temp;
        return found;
    }
    public  boolean exist(char[][] board, String word){
        //iterate the rows and columns to find the first element
        this.rows=board.length;
        this.cols=board[0].length;
        boolean flag=false;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(search(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return flag;
    }
}

public class WordSearch{
     public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        Solution s= new Solution();
        System.out.println(s.exist(board, word));
    }
}