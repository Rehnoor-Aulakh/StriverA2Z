package MediumProblems;

import Traversals.TreeNode;
import java.util.*;

public class SymmetricBinaryTree {
    public boolean isSymmetricIterative(TreeNode root) {
        if(root==null) return true;
        //Level Order Traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left= q.poll();
            TreeNode right= q.poll();
            if(left==null && right==null) continue;
            if(left==null || right==null) return false;
            if(left.data!=right.data) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        //divide it into 2 parts
        TreeNode root1= root.left;
        TreeNode root2= root.right;
        if(check(root1,root2)) return true;
        return false;
    }
    private boolean check(TreeNode root1 , TreeNode root2){
        //root1's left must be root2's right
        //root1's right must be root2's left
        //and this must be recursively true
        if(root1==null && root2==null) return true;
        if((root1==null && root2!=null) || (root1!=null && root2==null)) return false;
        if(root1.data==root2.data){
            //check left and right
            return check(root1.left,root2.right) && check(root1.right, root2.left);
        }
        return false;
    }
}
