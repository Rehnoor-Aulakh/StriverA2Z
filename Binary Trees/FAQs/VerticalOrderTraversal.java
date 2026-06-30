package FAQs;
import Traversals.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        //perform level order Traversal
        Queue<Tuple> queue= new LinkedList<>();
        queue.add(new Tuple(root, 0,0));
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node= tuple.node;
            int x= tuple.x;
            int y= tuple.y;

            if(node.left!=null){
                queue.add(new Tuple(node.left, x-1, y+1));
            }
            if (node.right != null){
                queue.add(new Tuple(node.right, x+1, y+1));
            }

            //now add this tuple to your treemap datastructure
            //first we need to check if for the current vertical, there is already a list in datastructure
            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).add(node.data);

        }
        //after all this, our datastructure is ready to create the final answer
        //process it vertical by vertical, means we need to iterate the TreeMap
        //it is already sorted by x
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){
            List<Integer> currVertical= new ArrayList<>();
            //this is for every level
            for(PriorityQueue<Integer> nodes: ys.values()){
                while(!nodes.isEmpty()){
                    currVertical.add(nodes.poll());
                }
            }
            ans.add(currVertical);
        }
        return ans;

    }
}
