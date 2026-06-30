package Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
    public int num;
    public TreeNode node;
    public Pair(int num, TreeNode node){
        this.num= num;
        this.node = node;
    }
}
public class Pre_Post_In_Single_Traversal {
    List<List<Integer>> treeTraversal(TreeNode root){
        Stack<Pair> st= new Stack<Pair>();
        st.push(new Pair(1,root));
        List<Integer> pre= new ArrayList<>();
        List<Integer> in= new ArrayList<>();
        List<Integer> post= new ArrayList<>();

        while(!st.isEmpty()){
            Pair it= st.pop();
            if(it.num==1){
                it.num++;
                //if left is there
                st.push(it);
                pre.add(it.node.data);
                if(it.node.left!=null){
                    st.push(new Pair(1,it.node.left));
                }
            }
            else if(it.num==2){
                it.num++;
                st.push(it);
                in.add(it.node.data);
                if(it.node.right !=null){
                    st.push(new Pair(1, it.node.right));
                }
            }
            else{
                post.add(it.node.data);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(in);
        ans.add(pre);
        ans.add(post);
        return ans;
    }
}
