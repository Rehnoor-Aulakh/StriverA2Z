package Medium;
import java.util.*;

public class SuccessorPredecessor {
    public List<Integer> succPredBST(TreeNode root, int key) {
        Integer pred=null;
        Integer succ= null;
        TreeNode curr=root;

        while(curr!=null){
            if(curr.data<key){
                //this can be predecessor
                pred= curr.data;
                //check on the right for a better option
                curr=curr.right;
            }
            else if(curr.data>key){
                //this can be successor
                succ= curr.data;
                curr=curr.left;
            }
            else{
                //found the node
                TreeNode temp= curr.left;
                //left's rightmost will be the predecessor
                //right's leftmost will be successor
                while(temp!=null){
                    //go right
                    pred=temp.data;
                    temp=temp.right;
                }
                //successor
                temp=curr.right;
                while(temp!=null){
                    succ= temp.data;
                    temp=temp.left;
                }
                break;
            }
        }
        List<Integer> ans= new ArrayList<>();
        if(pred==null){
            ans.add(-1);
        }
        else{
            ans.add(pred);
        }
        if(succ==null){
            ans.add(-1);
        }
        else{
            ans.add(succ);
        }
        return ans;
    }


}
