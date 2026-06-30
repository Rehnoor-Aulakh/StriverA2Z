public class PrintMatrix{
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
    
}