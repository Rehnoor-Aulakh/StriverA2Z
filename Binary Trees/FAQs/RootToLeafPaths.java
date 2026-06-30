package FAQs;
import java.util.*;
import Traversals.TreeNode;

public class RootToLeafPaths {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t= new ArrayList<>();
        backtrack(root,  t, ans);
        return ans;
    }
    private void backtrack(TreeNode root, List<Integer> t, List<List<Integer>> ans){
        if(root==null) return;
        t.add(root.data);
        if(root.left==null && root.right==null){
            //this is a leaf node, add the t to answer
            ans.add(new ArrayList<>(t));
        }
        else{
            backtrack(root.left, t, ans);
            backtrack(root.right, t, ans);
        }
        //undo
        t.remove(t.size()-1);

    }
}
