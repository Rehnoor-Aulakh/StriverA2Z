package FAQs;
import java.util.*;

public class BSTIterator {
    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st= new Stack<>();
        //go left
        TreeNode t= root;
        while(t!=null){
            st.push(t);
            t=t.left;
        }
    }

    public int next() {
        //pop from stack and return
        TreeNode top = st.pop();
        int ans= top.data;
        pushAllLeft(top.right);

        return ans;
    }
    private void pushAllLeft(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}