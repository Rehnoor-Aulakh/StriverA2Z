import java.util.*;

public class NoOfVisiblePeopleInQueue_1944 {
    public static int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st= new Stack<>();
        int n = heights.length;
        int[] ans = new int[n];
        // the last person cannot see anyone
        ans[n-1]= 0;
        // push the last element onto the stack because for the second last person, he is the tallest after him
        st.push(heights[n-1]);
        // start iterating from n-2 to 0
        for(int i=n-2; i>=0; i--) {
            int count=0;
            // if the current element is greater than the top of stack, then in stack someone taller is still there which ith person can see
            while(!st.isEmpty() && st.peek()<= heights[i]) {
                count++;
                st.pop();
            }
            // for the element in the stack (if it is there) who is taller than current element
            if(!st.isEmpty()) {
                count++;
            }
            st.push(heights[i]);
            ans[i] = count;
        }
        return ans;
    }

    static void main() {
        System.out.println(Arrays.toString(canSeePersonsCount(new int[]{10,6,8,5,11,9})));
    }
}
