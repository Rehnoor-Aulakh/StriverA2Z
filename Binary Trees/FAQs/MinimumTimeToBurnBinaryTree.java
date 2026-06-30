package FAQs;
import java.util.*;
import Traversals.TreeNode;

public class MinimumTimeToBurnBinaryTree {
    private TreeNode markParents(Map<TreeNode, TreeNode> parent_track, TreeNode root, int start){
        //first bfs for parent marking
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        TreeNode target=null;
        while(!queue.isEmpty()){
            TreeNode curr= queue.poll();
            if(curr.data==start){
                target=curr;
            }
            if(curr.left!=null){
                parent_track.put(curr.left, curr);
                queue.add(curr.left);
            }
            if(curr.right!=null){
                parent_track.put(curr.right, curr);
                queue.add(curr.right);
            }
        }
        return target;
    }
    public int timeToBurnTree(TreeNode root, int start) {
        if(root==null) return 0;
        Map<TreeNode,TreeNode> parent_track = new HashMap<>();
        TreeNode target= markParents(parent_track, root,start);
        Queue<TreeNode> queue= new LinkedList<>();
        Map<TreeNode, Boolean> visited= new HashMap<>();
        int currLevel=0;
        queue.add(target);
        visited.put(target,true);
        while(!queue.isEmpty()){
            int size=queue.size();
            //all the nodes at the current level
            currLevel++;
            for(int i=0;i<size;i++){
                TreeNode curr= queue.poll();
                //go left
                if(curr.left!=null && visited.get(curr.left)==null){
                    queue.add(curr.left);
                    visited.put(curr.left, true);
                }
                //go right
                if(curr.right!=null && visited.get(curr.right)==null){
                    queue.add(curr.right);
                    visited.put(curr.right, true);
                }
                //go to parent
                if(parent_track.get(curr)!=null && visited.get(parent_track.get(curr))==null){
                    queue.add(parent_track.get(curr));
                    visited.put(parent_track.get(curr),true);
                }
            }
        }
        return currLevel-1;
    }
}
