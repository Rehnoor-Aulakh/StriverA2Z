import java.util.*;

public class BuildingsWithAnOceanView {
    // O(1) space
    public List<Integer> findBuildings(int[] heights) {
        // this is a straightforward monotonic stack question
        // so what happens here is that the last index of the array will always have the ocean view
        // now as we move forward, we will maintain a stack, and then if the element is greater than st.peek(),
        // add this element to the ans list
        List<Integer> ans = new ArrayList<>();
        int n = heights.length;
        if(n==0) return ans;
        if(n==1){
            ans.add(0);
            return ans;
        }
        int maxi = heights[n-1];
        ans.add(n-1);
        for(int i=n-2;i>=0;i--){
            if(heights[i]>maxi){
                //push this onto the stack, because this is larger than the previous, so it will have a ocean view
                maxi = heights[i];
                ans.add(i);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
    public List<Integer> findBuildingsStack(int[] heights) {
        // this is a straightforward monotonic stack question
        // so what happens here is that the last index of the array will always have the ocean view
        // now as we move forward, we will maintain a stack, and then if the element is greater than st.peek(),
        // add this element to the ans list
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        if(n==0) return ans;
        if(n==1){
            ans.add(0);
            return ans;
        }
        st.push(heights[n-1]);
        ans.add(n-1);
        for(int i=n-2;i>=0;i--){
            if(heights[i]>st.peek()){
                //push this onto the stack, because this is larger than the previous, so it will have a ocean view
                st.push(heights[i]);
                ans.add(0, i);
            }
        }
        return ans;
    }
}
