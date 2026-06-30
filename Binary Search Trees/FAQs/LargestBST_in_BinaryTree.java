package FAQs;


class NodeValue{
    public int maxVal,  minVal, maxSize;

    NodeValue(int maxVal, int minVal, int maxSize){
        this.maxVal=maxVal;
        this.minVal=minVal;
        this.maxSize=maxSize;
    }
}

public class LargestBST_in_BinaryTree {
    private NodeValue largestBSTSubtreeHelper(TreeNode root){
        if(root==null){
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        //postorder traversal
        NodeValue left= largestBSTSubtreeHelper(root.left);
        NodeValue right= largestBSTSubtreeHelper(root.right);
        if(left.maxVal< root.data && right.minVal>root.data){
            //then this bst is valid
            return new NodeValue(Math.max(right.maxVal,root.data), Math.min(left.minVal,root.data), 1+left.maxSize+right.maxSize);
        }
        else{
            //this is an invalid bst
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize, right.maxSize));
        }
    }
    public int largestBST(TreeNode root) {
        return largestBSTSubtreeHelper(root).maxSize;
    }
}
