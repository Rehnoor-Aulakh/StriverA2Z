package Medium;

public class InsertNodeInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        if(root.data>val){
            //go left
            if(root.left==null){
                root.left= new TreeNode(val);
                return root;
            }
            else{
                insertIntoBST(root.left, val);

            }
        }
        else{
            if(root.right==null){
                root.right= new TreeNode(val);
                return root;
            }
            else{
                insertIntoBST(root.right, val);
            }
        }
        return root;
    }
}
