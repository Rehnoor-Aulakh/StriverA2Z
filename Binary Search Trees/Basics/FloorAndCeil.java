package Basics;

import java.util.*;

public class FloorAndCeil {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        int[] ans=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        find(root, key, ans);
        List<Integer> result= new ArrayList<>();
        result.add(ans[0]);
        result.add(ans[1]);
        return result;
    }
    private void find(TreeNode root, int key, int[] ans){
        if(root==null) return;
        if(root.data==key){
            ans[0]=key;
            ans[1]=key;
        }
        else{
            if(root.data<key){
                //this is a possibility of floor
                ans[0]=root.data;
                //go right
                find(root.right, key, ans);
            }
            else{
                ans[1]=root.data;
                //go left
                find(root.left, key, ans);
            }
        }
    }
}
