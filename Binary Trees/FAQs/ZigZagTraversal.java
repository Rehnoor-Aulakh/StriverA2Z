package FAQs;
import Traversals.TreeNode;

import java.util.*;
public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null) return ans;
        boolean flag= true;
        //true means left to right, false means right to left
        while(!queue.isEmpty()){
            int size= queue.size();
            List<Integer> currLevel = new ArrayList<>(Collections.nCopies(size,0));
            //this loop is for one level
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                int index= flag ? i : (size-i-1);
                //Insert the node's value at the determined index
                currLevel.set(index, curr.data);

                    if(curr.left!=null){
                        queue.add(curr.left);
                    }
                    if(curr.right!=null){
                        queue.add(curr.right);
                    }
                }

            flag=!flag;
            ans.add(currLevel);
        }
        return ans;
    }
}
