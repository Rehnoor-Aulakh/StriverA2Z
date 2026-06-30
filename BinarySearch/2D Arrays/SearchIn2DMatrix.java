public class SearchIn2DMatrix{
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols= matrix[0].length;
        int low=0;
        int high= (rows*cols)-1;
        while(low<=high){
            //Calculate mid as flattened
            int mid=(low+high)/2;
            int row=mid/cols;
            int col=mid%cols;
            if(target==matrix[row][col]){
                return true;
            }
            else if(target<matrix[row][col]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][]={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target=3;
        System.out.println(searchMatrix(matrix, target));
    }
}