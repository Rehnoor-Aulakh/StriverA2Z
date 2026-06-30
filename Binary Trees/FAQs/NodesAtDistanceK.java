package FAQs;
import java.util.*;
import Traversals.TreeNode;

public class NodesAtDistanceK {
    private void marksParents(TreeNode root, Map<TreeNode, TreeNode> parent_track){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current= queue.poll();
            if(current.left!=null){
                parent_track.put(current.left, current);
                queue.add(current.left);
            }
            if(current.right!=null){
                parent_track.put(current.right, current);
                queue.add(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track= new HashMap<>();
        marksParents(root, parent_track);
        Map<TreeNode, Boolean> visited= new HashMap<>();
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()){
            int size= queue.size();
            if(curr_level==k) break;
            curr_level++;
            for(int i=0;i<size;i++){
                TreeNode curr= queue.poll();
                //add left node
                if(curr.left !=null && visited.get(curr.left)==null){
                    queue.add(curr.left);
                    visited.put(curr.left, true);
                }
                //add right node
                if(curr.right!=null && visited.get(curr.right)==null){
                    queue.add(curr.right);
                    visited.put(curr.right, true);
                }
                //add parent node
                if(parent_track.get(curr)!=null && visited.get(parent_track.get(curr))==null){
                    queue.add(parent_track.get(curr));
                    visited.put(parent_track.get(curr),true);
                }

            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.poll().data);
        }
        return ans;
    }
}
