

public class PascalTriangleI{
    public static int pascalTriange(int r, int c){
        //first build the matrix
        int matrix[][]=new int[r+1][r+1];
        matrix[0][1]=1;
        PrintMatrix.printMatrix(matrix);
        //build the pascal triangle till r and c
        //base case
        for(int i=1;i<r;i++){
            for(int j=1;j<=c;j++){
                matrix[i][j]=matrix[i-1][j]+matrix[i-1][j-1];
            }
        }
        PrintMatrix.printMatrix(matrix);
        
        return matrix[r-1][c];
    }
    public static int findNCR(int N, int R){
        int ans=1;
        for(int r=0;r<R;r++){
            ans*=(N-r);
            ans/=(r+1);
        }
        return ans;
    }
    public static int pascalTriangleOptimised(int r, int c){
        return findNCR(r-1, c-1);
    }
    
    
    public static void main(String[] args) {
        //indexing is 1 based
        System.out.println(pascalTriange(4, 2));
        // System.out.println(findNCR(7, 2));
        // System.out.println(pascalTriangleOptimised(4, 2));

    }
}