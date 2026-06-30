package MorrisTraversals;
import java.util.*;
import Traversals.TreeNode;

public class Morris_Inorder {
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> inorder= new ArrayList<>();
        TreeNode curr= root;
        while(curr!=null){
            //CASE 1- curr.left is null
            if(curr.left==null){
                inorder.add(curr.data);
                curr=curr.right;
            }

            //CASE 2- curr.left is not null
            else{
                //go to the rightmost node of the left subtree and connect the pointer to curr
                TreeNode left= curr.left;
                //curr.left is not null
                while(left.right!=null && left.right!=curr){
                    left=left.right;
                }
                //connect the pointer back
                if(left.right==null){
                    //create the THREAD
                    left.right= curr;
                    curr=curr.left;
                }
                else{
                    //it is already pointing to curr, means the thread was created
                    //move to threaded node's left and remove the thread
                    left.right=null;
                    //it is the root now
                    //push it
                    inorder.add(curr.data);
                    curr=curr.right;
                }

            }
        }
        return inorder;
    }
}
