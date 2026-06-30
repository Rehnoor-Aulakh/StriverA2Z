public class RotateMatrix{
    public static int[][] rotateMatrixBruteForce(int[][] matrix){
        //let us now do the 
        int n =matrix.length;
        int ans[][]= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //swap i with n-1-i and j is as it is
                ans[j][n-i-1]=matrix[i][j];
            }
        }
        return ans;
    }
    public static void rotateMatrix(int[][] matrix){
        //first transpose then reverse
        //transpose
        int i=0,j=0;
        for(i=0;i<matrix.length;i++){
            for(j=0;j<i;j++){
                //swap i,j with j,i
                int t= matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
        //now we just need to reverse all the rows
        //n rows, so O(n^2) time
        for(i=0;i<matrix.length;i++){
            //reverse matrix[i]
            for(j=0;j<matrix[i].length/2;j++){
                //swap matrix[i][j] with matrix[i][matrix[i].length-1-j]
                int t= matrix[i][j];
                matrix[i][j]=matrix[i][matrix[i].length-1-j];
                matrix[i][matrix[i].length-1-j]=t;
            }
        }

    }
    public static void main(String[] args) {
        int nums[][]={{1,2,3},{4,5,6},{7,8,9}};
        
        PrintMatrix.printMatrix((nums));
        PrintMatrix.printMatrix(rotateMatrixBruteForce(nums));
        rotateMatrix(nums);
        PrintMatrix.printMatrix((nums));

    }
}