package FAQs;
import java.util.*;
import Traversals.TreeNode;

public class RightViewOfBinaryTree {
    static class Tuple{
        TreeNode node;
        int x;
        int y;
        Tuple(TreeNode node, int x, int y){
            this.node= node;
            this.x=x;
            this.y=y;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        //level order traversal
        Queue<Tuple> queue= new LinkedList<>();
        //key is level and value is the data of the node
        TreeMap<Integer,Integer> map = new TreeMap<>();
        // if for the same level, a bigger vertical i.e. x is there, then replace it
        queue.add(new Tuple(root, 0, 0));
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            Tuple tuple= queue.poll();
            TreeNode node= tuple.node;
            int x= tuple.x;
            int y = tuple.y;
            if(node.left!=null){
                queue.add(new Tuple(node.left, x-1,y+1));
            }
            if(node.right!=null){
                queue.add(new Tuple(node.right, x+1, y+1));
            }
            //add this to our answer
            //if a bigger y comes, then it will be replaced
            map.put(y, node.data);
        }
        //build the answer from the map
        for(Integer i: map.values()){
            ans.add(i);
        }
        return ans;
    }
}
