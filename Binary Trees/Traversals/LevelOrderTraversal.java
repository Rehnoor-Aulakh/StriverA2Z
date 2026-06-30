package Traversals;

import java.util.*;
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        List<List<Integer>> ans= new ArrayList<>();

        queue.add(root);
        TreeNode curr= root;
        while(!queue.isEmpty()){
            List<Integer> t= new ArrayList<>();
            int size= queue.size();
            for(int i=0;i<size;i++){
                curr=queue.poll();
                t.add(curr.data);
                //store left and right in the queue
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            ans.add(t);
        }
        return ans;
    }
}
