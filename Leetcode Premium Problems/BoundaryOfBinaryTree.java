import java.util.*;

public class BoundaryOfBinaryTree {

    private void getLeftNodes(TreeNode root, List<Integer> leftNodes){
        if(root==null) return;
        if(root.left == null && root.right==null){
            return;
        }
        // move left and store that in leftNodes
        leftNodes.add(root.val);
        if(root.left!=null){
            //go left only
            getLeftNodes(root.left, leftNodes);
            return;
        }else{
            // go right
            getLeftNodes(root.right, leftNodes);
        }
    }
    private void getLeafNodes(TreeNode root, List<Integer> leaves){
        if(root==null) return;
        if(root.left==null && root.right==null){
            leaves.add(root.val);
        }
        // go left
        getLeafNodes(root.left, leaves);
        getLeafNodes(root.right, leaves);
    }
    private void getRightNodes(TreeNode root, List<Integer> rightNodes){
        //check leaf node
        if(root==null) return;
        if(root.left==null && root.right==null){
            return;
        }
        rightNodes.add(root.val);
        if(root.right!=null){
            //go right
            getRightNodes(root.right, rightNodes);
            return;
        }
        else{
            getRightNodes(root.left, rightNodes);
        }
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        if(root==null) return leaves;
        if(root.left==null && root.right==null){
            leaves.add(root.val);
            return leaves;
        }
        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();
        getLeftNodes(root.left, leftNodes);
        getLeafNodes(root, leaves);
        leftNodes.addAll(leaves);
        getRightNodes(root.right, rightNodes);
        Collections.reverse(rightNodes);
        leftNodes.addAll(rightNodes);
        leftNodes.add(0,root.val);
        return leftNodes;
    }
}
