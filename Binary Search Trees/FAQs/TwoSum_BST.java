package FAQs;

import java.util.Stack;

class Solution{
    Stack<TreeNode> left;
    Stack<TreeNode> right;
    Solution(){
        left= new Stack<>();
        right= new Stack<>();

    }
    private void initializeLeft(TreeNode root){
        while(root!=null){
            left.push(root);
            root=root.left;
        }
    }
    private void initializeRight(TreeNode root){
        while(root!=null){
            right.push(root);
            root=root.right;
        }
    }
    public boolean findTarget(TreeNode root, int k){
        initializeLeft(root);
        initializeRight(root);
        //now compare the leftmost and rightMost
        TreeNode leftTop = getNext();
        TreeNode rightTop = getPrev();
        while(leftTop!=null && rightTop!=null && leftTop!=rightTop){
            int sum=leftTop.data+rightTop.data;
            if(sum==k){
                return true;
            }
            else if(sum<k){
                //sum is smaller than k, I need to increase the sum, so move the left pointer forward
                leftTop = getNext();
            }
            else{
                rightTop = getPrev();
            }
        }
        return false;
    }
    private TreeNode getNext(){
        if(left.isEmpty()) return null;
        TreeNode node= left.pop();
        moveLeft(node.right);
        return node;
    }
    private TreeNode getPrev(){
        if(right.isEmpty()) return null;
        TreeNode node= right.pop();
        moveRight(node.left);
        return node;
    }
    private void moveLeft(TreeNode root){
        //add root
        while(root!=null){
            left.push(root);
            root=root.left;
        }

    }
    private void moveRight(TreeNode root){
        while(root!=null){
            right.push(root);
            root=root.right;
        }
    }
}
