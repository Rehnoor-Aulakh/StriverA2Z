
import java.util.Arrays;

public class FindPeakElementII{
    private static int findMax(int[][] matrix, int mid){
        int maxi=Integer.MIN_VALUE;
        int maxIndex=-1;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][mid]>maxi){
                maxi=matrix[i][mid];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
    public static int[] findPeakGrid(int[][] matrix) {
        int ans[]= new int[2];
        int rows=matrix.length;
        int cols=matrix[0].length;
        int low=0;//0th column
        int high=cols-1;//last column
        while(low<=high){
            int mid=(low+high)/2;//middle column
            //find the maximum index in the middle column, which will be row
            int row=findMax(matrix,mid);
            //once you have the row, I know this element is greater than top and bottom, because it is maximum, just need to make sure it is greater than left and right
            int left=mid>=0?matrix[row][mid-1]:-1;
            int right=mid<cols?matrix[row][mid+1]:-1;
            if(matrix[row][mid]>left&&matrix[row][mid]>right){
                ans[0]=row;
                ans[1]=mid;
                return ans;
            }
            else if(matrix[row][mid]<left){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix={{10,20,15},{21,30,14},{7,16,32}};
        System.out.println(Arrays.toString(findPeakGrid(matrix)));
    }
}