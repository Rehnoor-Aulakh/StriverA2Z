package Medium;


public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.data==key){
            return helper(root);
        }
        TreeNode dummy= root;
        while(root!=null){
            if(root.data<key){
                //key is larger, so we need to go to right
                if(root.right!=null && root.right.data==key){
                    root.right=helper(root.right);
                    break;
                }
                else{
                    root=root.right;
                }
            }
            else{
                if(root.left!=null && root.left.data==key){
                    root.left= helper(root.left);
                    break;
                }
                else{
                    root=root.left;
                }
            }
        }
        return dummy;
    }
    private TreeNode helper(TreeNode root){
        //root points to the node to be deleted
        //and return after deleting this root node
        if(root.left==null){
            return root.right;
        }
        if(root.right==null){
            return root.left;
        }
        //otherwise go to the rightmost child of left node
        TreeNode rightChild= root.right;
        TreeNode leftChild= root.left;
        TreeNode target= leftChild;
        while(target.right!=null){
            target=target.right;
        }
        target.right= rightChild;
        return leftChild;
    }
}
