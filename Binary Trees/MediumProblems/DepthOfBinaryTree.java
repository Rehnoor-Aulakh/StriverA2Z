package MediumProblems;

import Traversals.TreeNode;

import java.util.*;

public class DepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));

    }
    public int maxDepthIterative(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        int ans=0;
        while(!queue.isEmpty()){
            //pop a single level
            int size= queue.size();
            ans+=1;
            for(int i=0;i<size;i++){
                TreeNode curr= queue.poll();
                //push the left and right
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }

        }
        return ans;
    }
}
