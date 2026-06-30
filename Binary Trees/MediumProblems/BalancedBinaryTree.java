package MediumProblems;

import Traversals.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalancedOptimal(TreeNode root){
        if(height(root)==-1)return false;
        return true;
    }
    private int height(TreeNode root){
        if(root==null) return 0;
        int leftHeight= height(root.left);
        int rightHeight= height(root.right);
        if(leftHeight==-1 || rightHeight==-1) return -1;
        if(Math.abs(leftHeight-rightHeight) >1) return -1;
        else return 1+Math.max(leftHeight,rightHeight);
    }
    public boolean isBalanced(TreeNode root) {
        //traverse the entire tree
        //find the height of left and right subtree recursively and check if the condition fails
        int leftHeight= height(root.left);
        int rightHeight= height(root.right);
        if(Math.abs(leftHeight-rightHeight)<=1) {
            return isBalanced(root.left) && isBalanced(root.right);

        }
        return false;

    }
}
