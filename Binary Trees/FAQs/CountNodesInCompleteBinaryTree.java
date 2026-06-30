package FAQs;
import java.util.*;
import Traversals.TreeNode;

public class CountNodesInCompleteBinaryTree {
    private int leftHeight(TreeNode root){
        //go left till you reach null
        if(root==null){
            return 0;
        }
        return 1+ leftHeight(root.left);
    }
    private int rightHeight(TreeNode root){
        if(root==null){return 0;}
        return 1+rightHeight(root.right);
    }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lh= leftHeight(root);
        int rh = rightHeight(root);
        if(lh==rh){
            return (int) (Math.pow(2,lh)-1);
        }
        else{
            return 1+ countNodes(root.left)+countNodes(root.right);
        }
    }
}
