import java.util.*;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        //first and foremost step is to calculate the prefix sum matrix
        int rows=matrix.length;
        int cols=matrix[0].length;
        //I want to go on calculate the prefix sum in place
        //iterate on the columns only
        for(int j=0;j<cols;j++){
            int prefixSum=0;
            //then iterate on the rows
            for(int i=0;i<rows;i++){
                if(matrix[i][j]=='1'){
                    prefixSum+=1;
                    matrix[i][j]=(char)(prefixSum+'0');
                }
                else{
                    prefixSum=0;
                }
            }
        }
        //now for every row, call the largest histogram area function
        int maxArea= 0;
        for(char[] row: matrix){
            maxArea=Math.max(maxArea, largestRectangleArea(row));
        }
        return maxArea;
    }

    private int largestRectangleArea(char[] heights) {
        int maxArea=0;
        Stack<Integer> st = new Stack<>();
        int n=heights.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && (heights[st.peek()]-'0')>(heights[i]-'0')){
                int element= st.pop();
                int nse= i;
                int pse= st.isEmpty()?-1:st.peek();
                maxArea=Math.max(maxArea, (heights[element]-'0')*(nse-pse-1));
            }
            st.push(i);
        }
        int nse=n;
        while(!st.isEmpty()){
            int element=st.pop();
            int pse = st.empty()?-1:st.peek();
            maxArea= Math.max(maxArea, (heights[element]-'0')*(nse-pse-1));
        }
        return maxArea;
    }

    static void main() {

    }
}
