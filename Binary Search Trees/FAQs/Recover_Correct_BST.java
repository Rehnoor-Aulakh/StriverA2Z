package FAQs;
import java.util.*;

class OptimalSolution{
    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;

    private void inorder(TreeNode root){
        if(root==null) return;
        //left call
        inorder(root.left);
        //current node processing logic
        if(prev!=null && root.data<prev.data){
            if(first==null){
                first= prev;
                middle=root;
            }
            else{
                last= root;
            }
        }
        //mark this node as previous
        prev=root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root){
        first=middle=last= null;
        prev= new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){
            //swap them
            int t=first.data;
            first.data= last.data;
            last.data= t;
        }
        else{
            //swap first and middle
            int t= first.data;
            first.data= middle.data;
            middle.data=t;
        }
    }
}

public class Recover_Correct_BST {
    public void recoverTreeBrute(TreeNode root) {
        //create an arrayList of nodes
        List<TreeNode> list= new ArrayList<>();
        //perform inorder traversal
        inorder(list, root);
        //now that the list is ready, keep 2 pointers
        int size= list.size();
        int left=0, right=size-1;
        while(left<right){
            //check if both are incorrect
            if((list.get(left).data > list.get(left+1).data) && (list.get(right).data < list.get(right-1).data)){
                //swap there data and return
                int t= list.get(left).data;
                list.get(left).data= list.get(right).data;
                list.get(right).data= t;
                return;
            }
            //check left if it is correct
            if(list.get(left).data < list.get(left+1).data){
                left++;
            }
            if(list.get(right).data > list.get(right-1).data){
                right--;
            }

        }
    }
    private void inorder(List<TreeNode> list, TreeNode root){
        if(root==null) return;
        //go left
        inorder(list, root.left);
        list.add(root);
        inorder(list, root.right);
    }
}
