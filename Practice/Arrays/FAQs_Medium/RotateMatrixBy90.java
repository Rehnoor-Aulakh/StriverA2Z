package FAQs_Medium;

public class RotateMatrixBy90 {
    public void optimal(int[][] matrix) {
        // first transpose
        int n = matrix.length;
        for(int i=0; i<n; i++){
            // j starts from i+1, right side of diagonal
            for(int j=i+1; j<n; j++){
                // now swap i,j with j,i
                matrix[i][j]=matrix[i][j]^matrix[j][i];
                matrix[j][i]= matrix[i][j]^matrix[j][i];
                matrix[i][j]= matrix[i][j]^matrix[j][i];
            }
        }
        // now reverse every row
        for(int i=0; i<n; i++){
            // for each column till n/2
            for(int j=0; j<n/2; j++){
                int t = matrix[i][j];
                matrix[i][j]= matrix[i][n-j-1];
                matrix[i][n-1-j] = t;
            }
        }
    }
    public int[][] rotateBrute(int[][] matrix){
        int n = matrix.length;

        int[][] ans = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                ans[j][n-1-i] = matrix[i][j];
            }
        }
        return ans;
    }
}
