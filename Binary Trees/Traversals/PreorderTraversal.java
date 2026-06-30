package Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorder(TreeNode root){
        List<Integer> ans= new ArrayList<>();
        Stack<TreeNode> st= new Stack<>();
        TreeNode t= root;
        if(root==null) return ans;
        st.push(root);
        while(t!=null || !st.isEmpty()){
            t=st.pop();
            ans.add(t.data);
            if(t.right!=null){
                st.push(t.right);
            }
            if(t.left!=null){
                st.push(t.left);
            }
        }
        return ans;
    }
    public List<Integer> preorderIterative(TreeNode root){
        List<Integer> ans= new ArrayList<>();
        Stack<TreeNode> st= new Stack<>();
        TreeNode t= root;
        while(t!=null || !st.isEmpty()){
            //store into stack, and arraylist and then go left
            while(t!=null){
                ans.add(t.data);
                st.push(t);
                t=t.left;
            }
            //you are now at the leaf node, pop the top
            t=st.pop();
            //now go right
            t=t.right;
        }
        return ans;
    }
}
