package FAQs;
import Traversals.TreeNode;

import java.util.*;
public class TopViewOfBinaryTree {
    static class Tuple{
        TreeNode node;
        int x;
        int y;
        Tuple(TreeNode node, int x, int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
    public List<Integer> topView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<Tuple> queue= new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.add(new Tuple(root, 0,0));
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;
            if(node.left!=null){
                queue.add(new Tuple(node.left, x-1, y+1));
            }
            if(node.right!=null){
                queue.add(new Tuple(node.right, x+1, y+1));
            }
            //add this node to treemap
            //means it already has that vertical, and we want only the smallest level for it
            //since we are going level by level only, we dont have to worry about it
            //for every vertical, just a single value
            if(!map.containsKey(x)){
                map.put(x,node.data);
            }

        }
        //now our treemap is ready, just build the answer out of it
        for(Integer i: map.values()){
            ans.add(i);
        }
        return ans;
    }
}
