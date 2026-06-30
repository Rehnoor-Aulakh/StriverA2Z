package FAQs;
import java.util.*;
import Traversals.TreeNode;



public class MaximumWidthOfBinaryTree {
    static class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node, int num){
            this.node= node;
            this.num= num;
        }
    }
    public int widthOfBinaryTree(TreeNode root){
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int min = q.peek().num; //to make the id starting from 0
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                int cur_id = q.peek().num - min;
                TreeNode node= q.peek().node;
                q.poll();
                if(i==0) first= cur_id;
                if(i==size-1) last= cur_id;
                if(node.left!=null){
                    q.add(new Pair(node.left, (2*cur_id)+1));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right, (2*cur_id)+2));
                }
            }
            ans= Math.max(ans, last-first+1);
        }
        return ans;
    }
}
