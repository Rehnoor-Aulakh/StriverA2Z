package Basics;

public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(root.data==val){
            return root;
        }
        else if(root.data<val){
            //val is larger so go right
            return searchBST(root.right, val);
        }
        else{
            return searchBST(root.left, val);
        }
    }
}
