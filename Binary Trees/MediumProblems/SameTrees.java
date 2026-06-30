package MediumProblems;

import Traversals.TreeNode;

public class SameTrees {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q!=null) return false;
        if(p!=null && q==null) return false;
        if(p==null && q==null) return true;
        if(p.data==q.data){
            //go left and go right
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

        }
        return false;
    }
}
