package FAQs;
import Traversals.TreeNode;

import java.util.*;

public class BoundaryTraversal {
    public List<Integer> boundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        ans.add(root.data);
        //do the left boundary traversal without the leaf nodes
        leftBoundary(root.left,ans);
        leafNodes(root.left,ans);
        leafNodes(root.right,ans);
        Stack<Integer> st = new Stack<>();
        rightBoundary(root.right, st);
        //pop from the stack and put it to arrayList
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    private void leftBoundary(TreeNode root, List<Integer> ans){
        if(root==null) return;
        //exclude the leaf nodes
        if(root.left==null && root.right==null) return;
        //otherwise go left
        ans.add(root.data);
        if(root.left!=null){
            leftBoundary(root.left, ans);
        }
        //otherwise go right
        else{
            leftBoundary(root.right,ans);
        }
    }
    private void leafNodes(TreeNode root, List<Integer> ans){
        //do the preorder traversal, and in the base case, if it is a leaf node, add it to answer
        if(root==null) return;
        //process root
        if(root.left==null && root.right==null) ans.add(root.data);
        //go left
        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }
    private void rightBoundary(TreeNode root, Stack<Integer> st){
        //go right, if right is not there, then go left, do not include leaf
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        st.push(root.data);
        if(root.right!=null){
            rightBoundary(root.right, st);
        }
        else {
            rightBoundary(root.left, st);
        }
    }
}
