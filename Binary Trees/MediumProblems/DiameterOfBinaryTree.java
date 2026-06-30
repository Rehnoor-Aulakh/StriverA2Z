package MediumProblems;

import Traversals.TreeNode;

class Solution {
    public int diameterOfBinaryTree(TreeNode root){
        int[] diameter= new int[1];
        diameter[0]=0;

        height(root, diameter);
        return diameter[0];
    }
    private int height(TreeNode node, int[] diameter){
        if(node==null){
            return 0;
        }
        int[] lh = new int[1];
        int[] rh = new int[1];
        lh[0]= height(node.left, diameter);
        rh[0]= height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh[0]+rh[0]);

        return 1+Math.max(lh[0], rh[0]);
    }
}
