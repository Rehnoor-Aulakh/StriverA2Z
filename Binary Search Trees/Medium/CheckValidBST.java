package Medium;

public class CheckValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long min, long max){
        if(root==null) return true;
        if(root.data<=min || root.data>=max){
            return false;
        }

        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }
}
