import java.util.*;

public class LargestRectangleInHistogram {
    public static int largestRectangleAreaOptimized(int[] heights) {
        int maxArea=0;
        Stack<Integer> st = new Stack<>();
        int n=heights.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int element= st.pop();
                int nse= i;
                int pse= st.isEmpty()?-1:st.peek();
                maxArea=Math.max(maxArea, heights[element]*(nse-pse-1));
            }
            st.push(i);
        }
        int nse=n;
        while(!st.isEmpty()){
            int element=st.pop();
            int pse = st.empty()?-1:st.peek();
            maxArea= Math.max(maxArea, heights[element]*(nse-pse-1));
        }
        return maxArea;
    }
    public static int[] getPSE(int[] heights){
        Stack<Integer> st= new Stack<>();
        int n=heights.length;
        int[] ans= new int[n];
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                ans[i]=-1;
                st.push(i);
            }
            else if(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=st.peek();
                }
                st.push(i);

            }
            else if(!st.isEmpty() && heights[st.peek()]<heights[i]){
                ans[i]=st.peek();
                st.push(i);

            }

        }
        return ans;
    }
    public static int[] getNSE(int[] heights){
        Stack<Integer> st = new Stack<>();
        int n= heights.length;
        int[] ans= new int[n];
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                ans[i]=n;
                st.push(i);
            }
            else if(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                //this is smaller
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i]=n;
                }
                else{
                    ans[i]=st.peek();
                }
                st.push(i);
            }
            else if(!st.isEmpty() && heights[st.peek()]<heights[i]){
                ans[i]=st.peek();
                st.push(i);
            }
        }
        return ans;
    }
    public static int largestRectangleArea(int[] heights) {
        int[] pse= getPSE(heights);
        int[] nse= getNSE(heights);
        int ans=0;
        for(int i=0;i<heights.length;i++){
            ans=Math.max(ans,(nse[i]-pse[i]-1)*heights[i]);
        }
        return ans;
    }

    static void main() {
        System.out.println(largestRectangleAreaOptimized(new int[]{2,1,5,6,2,3}));
    }
}
