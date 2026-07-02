class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Pair<U,V>{
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

public class BinaryTreeLongestConsecutiveSequenceII {
    private int maxLen = 0;

    private Pair<Integer, Integer> longestPath(TreeNode node){
        if(node==null) return new Pair<>(0,0);
        int increasing = 1;
        int decreasing = 1;
        if(node.left!=null){
            Pair<Integer, Integer> left = longestPath(node.left);
            if(node.val-1 == node.left.val){
                decreasing = left.second+1;
            } else if(node.val+1 == node.left.val){
                increasing = left.first + 1;
            }
        }
        // check the right child
        if(node.right!=null)
        {
            Pair<Integer, Integer> right = longestPath(node.right);
            if(node.val-1 == node.right.val){
                decreasing = Math.max( right.second+1, decreasing);
            } else if(node.val+1 == node.right.val){
                increasing = Math.max( right.first + 1, increasing);
            }
        }
        maxLen = Math.max(maxLen, increasing+decreasing-1);
        return new Pair<>(increasing, decreasing);
    }
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxLen;
    }

}
