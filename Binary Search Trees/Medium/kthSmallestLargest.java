package Medium;
import java.util.*;

public class kthSmallestLargest {
    public List<Integer> kLargesSmall(TreeNode root, int k) {
        List<Integer> ans= new ArrayList<>();
        ans.add(kthSmallest(root, k));
        ans.add(kthLargest(root,k));
        return ans;
    }
    private void helper(TreeNode root, int[] i, int k){
        //do inorder traversal
        if(root==null){
            return;
        }
        helper(root.left, i,k);
        //root
        i[0]++;
        if(i[0]==k){
            i[1]=root.data;
            return;
        }

        helper(root.right, i,k);
    }
    private void helper2(TreeNode root, int[] i, int k){
        //do inorder traversal
        if(root==null){
            return;
        }
        helper2(root.right, i,k);
        //root
        i[0]++;
        if(i[0]==k){
            i[1]=root.data;
            return;
        }

        helper2(root.left, i,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] i=new int[2];
        i[0]=0;
        helper(root,i,k);
        return i[1];

    }
    public int kthLargest(TreeNode root, int k) {
        int[] i=new int[2];
        i[0]=0;
        helper2(root,i,k);
        return i[1];

    }
}
