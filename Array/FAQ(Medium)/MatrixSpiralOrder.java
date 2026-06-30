import java.util.*;

public class MatrixSpiralOrder{
    public static void printMatrix(int[][] matrix){
        int rows=matrix.length;
        int cols=matrix[0].length;
        System.out.println("Rows: "+rows);
        System.out.println("Cols: "+cols);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix){
        int rows=matrix.length;
        int cols=matrix[0].length;
        int left=0,right=cols-1;
        int top=0,bottom=rows-1;
        
        List<Integer> ans= new ArrayList<>();

        while(top<=bottom && left<=right){
            //first go from left to right
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            //second go from top to bottom
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);

            }
            right--;
            
            //third go from right to left
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //fourth go from bottom to up
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(matrix);
        System.out.println(spiralOrder(matrix));
    }
}