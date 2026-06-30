package MediumProblems;

import Traversals.TreeNode;

public class MaximumPathSum {
    int maxi;
    public MaximumPathSum(){
        maxi = Integer.MIN_VALUE;
    }
    private int helper(TreeNode root) {
        if(root==null) return 0;
        int leftSum = Math.max(helper(root.left),0);
        int rightSum = Math.max(helper(root.right),0);
        //inside path
        maxi = Math.max(maxi, leftSum+rightSum+root.data);
        //main path
        return root.data+ Math.max(leftSum, rightSum);
    }
    public int maxPathSum(TreeNode root){
        helper(root);
        return maxi;
    }
}
