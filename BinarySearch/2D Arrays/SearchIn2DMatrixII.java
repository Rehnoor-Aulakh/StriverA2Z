public class SearchIn2DMatrixII{
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols= matrix[0].length;
        int row=0;
        int col=cols-1;
        while(row<rows && col>=0){
            int value=matrix[row][col];
            if(value==target) return true;
            else if(value<target){
                //it will never be in the same row
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][]={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target=5;
        System.out.println(searchMatrix(matrix, target));
    }
}