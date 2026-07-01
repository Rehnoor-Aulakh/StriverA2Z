class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class BinaryTreeLongestConsecutiveSequence {
    public void dfs(TreeNode root, int[] maxLen, int currPathLen, int parentVal){
//        if(root.left!=null && root.val+1==root.left.val){
//            longestConsecutive(root, maxLen, currPathLen+1);
//            maxLen[0]= Math.max(maxLen[0], currPathLen+1 );
//        }
//        if(root.right!=null && root.val+1==root.right.val){
//            maxLen[0]= Math.
//        }

        /// I need a call for left, and I need a call for right, and I will pass the parentVal's value
        /// through the parameter, and if the parentVal's value+1 is the current node's value, then we
        ///  increment currPathLen
        if(root==null) return;
        if(root.val== parentVal +1){
            currPathLen++;
        }else{
            currPathLen=1;
        }
        maxLen[0]= Math.max(maxLen[0], currPathLen);
        dfs(root.left, maxLen, currPathLen, root.val);
        dfs(root.right, maxLen, currPathLen, root.val);
    }
    public int longestConsecutive(TreeNode root) {
        if(root== null) return 0;
        // logic, keep a counter of maxAnswer, we need to perform dfs on this tree,
        // go both left and right
        int[] maxLen = new int[]{1};
        dfs(root, maxLen,0,root.val);
        return maxLen[0];
    }
}
