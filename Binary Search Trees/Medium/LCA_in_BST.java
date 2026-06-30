package Medium;

public class LCA_in_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q){
            return root;
        }
        if(root==null){
            return root;
        }
        if((p.data<root.data && q.data>root.data) || (p.data>root.data && q.data<root.data)){
            return root;
        }
        if(p.data<root.data && q.data<root.data){
            //go left
            return lowestCommonAncestor(root.left, p,q);
        }
        else{
            return lowestCommonAncestor(root.right, p,q);
        }
    }
}
