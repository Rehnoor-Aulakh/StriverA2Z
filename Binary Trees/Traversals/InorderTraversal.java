package Traversals;

import java.util.*;

public class InorderTraversal {
    public List<Integer> inorder(TreeNode root){
        Stack<TreeNode> st= new Stack<>();
        List<Integer> ans= new ArrayList<>();
        TreeNode t= root;
        while(t!=null || !st.isEmpty()){
            //go left
            while(t!=null){
                st.push(t);
                t=t.left;
            }

                //there is a dead end
                t=st.pop();
                ans.add(t.data);

                t=t.right;

        }
        return ans;
    }
}
