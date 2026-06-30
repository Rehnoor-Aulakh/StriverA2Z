package Medium;


public class BST_From_Preorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    //i is the index of the array
    private TreeNode bstFromPreorder(int[] preorder, int bound, int[] i){
        if(i[0]==preorder.length || preorder[i[0]]>bound) return null;
        TreeNode root= new TreeNode(preorder[i[0]]);
        i[0]++;
        root.left= bstFromPreorder(preorder, root.data, i);
        root.right= bstFromPreorder(preorder, bound,i);
        return root;
    }
    public TreeNode bstFromPreorderBrute(int[] preorder) {
        if(preorder.length == 0){
            return null;
        }
        //construct bst
        TreeNode root= new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            insertIntoBST(root, preorder[i]);
        }
        return root;
    }
    private void insertIntoBST(TreeNode root, int data){
        if(root==null) return;
        if(root.data<data){
            //go right
            if(root.right==null){
                root.right= new TreeNode(data);
                return;
            }
            insertIntoBST(root.right, data);
        }
        else if(root.data>data){
            if(root.left==null){
                root.left= new TreeNode(data);
                return;
            }
            insertIntoBST(root.left,data);
        }
    }
}
