package FAQs;
import java.util.*;
import Traversals.TreeNode;

public class LeastCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root==q) return root;

        TreeNode left= lowestCommonAncestor(root.left, p, q);
        TreeNode right= lowestCommonAncestor(root.right, p, q);


        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
    public TreeNode lowestCommonAncestorBrute(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList= new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        List<TreeNode> t= new ArrayList<>();
        backtract(root, pList, qList, t, p, q);
        //iterate the pList and qList from the end, and find the common point
        int i=0;
        TreeNode node=null;
        while(i<pList.size() && i<qList.size()){
            if(pList.get(i)==qList.get(i)){
                node= pList.get(i);

            }else{
                break;
            }
            i++;
        }
        return null;
    }
    void backtract(TreeNode root, List<TreeNode> pList, List<TreeNode> qList, List<TreeNode> t, TreeNode p, TreeNode q){
        if(root==null) return;
        t.add(root);
        if(root==p){
            pList.clear();
            pList.addAll(t);
        }
        if(root==q){
            qList.clear();
            qList.addAll(t);
        }
        //otherwise move forward
        backtract(root.left, pList, qList, t, p, q);
        backtract(root.right, pList,qList, t, p, q);

        //remove this node
        t.remove(t.size()-1);
    }
}
