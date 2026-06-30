package MorrisTraversals;

import Traversals.TreeNode;
import java.util.*;

public class Morris_Preorder {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> inorder= new ArrayList<>();
        TreeNode curr= root;
        while(curr!=null){
            //CASE 1: if curr.left is null
            if(curr.left==null){
                //just push onto the list
                inorder.add(curr.data);
                //move right
                curr=curr.right;
            }
            else{
                //CASE 2: if curr.left is not null
                //go to extreme right of the left subtree
                TreeNode left= curr.left;
                while(left.right!=null && left.right!=curr){
                    left=left.right;
                }
                if(left.right==null){
                    //connect the thread
                    left.right=curr;
                    curr=curr.left;
                }
                else{
                    //thread is already connected
                    //remove the thread
                    left.right=null;
                    inorder.add(curr.data);
                    curr=curr.right;
                }
            }
        }
        return inorder;
    }
}
