package All_Problems;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int data;
    TreeNode(int data){
        this.data = data;
    }
}

public class BinaryTreeToDLL {
    ///  Logic: node's left should be node's left's rightmost
    ///  node's right should be node's right's leftmost
    private TreeNode prev = null;
    private TreeNode head = null;
    TreeNode bToDLL(TreeNode root) {
        if(root==null) return null;
        // this is a leaf node
        prev = null;
        head = null;
        convertToDLL(head);
        return head;
    }
    private void convertToDLL(TreeNode root){
        if(root==null) return;
        convertToDLL(root.left);
        if(prev==null){
            head = root;
        }else{
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        convertToDLL(root.right);
    }

}
