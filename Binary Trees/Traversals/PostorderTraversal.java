package Traversals;

import java.util.*;

public class PostorderTraversal {
    public List<Integer> postorder(TreeNode root){
        //we need to do Left Right Node
        // let us do Node Right Left which is similar to preorder and then reverse the list
        List<Integer> ans= new ArrayList<>();
        Stack<TreeNode> st= new Stack<>();
        if(root==null) return ans;
        st.push(root);
        TreeNode t= root;
        while(!st.isEmpty()){
            t=st.pop();
            ans.add(t.data);
            if(t.left!=null){
                st.push(t.left);
            }
            if(t.right!=null){
                st.push(t.right);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
    public List<Integer> postorderRecursive(TreeNode root) {
        //your code goes here
        List<Integer> ans= new ArrayList<>();
        postorder(root, ans);
        return ans;
    }
    private void postorder(TreeNode root, List<Integer> ans){
        if(root==null) return;
        //go left
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.data);
    }

}
