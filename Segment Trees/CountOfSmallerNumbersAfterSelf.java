import java.util.*;

class Solution{
    static class SegmentTreeNode{
        SegmentTreeNode left;
        SegmentTreeNode right;
        public int start;
        public int end;
        public int sum;
        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public SegmentTreeNode buildTree(int start, int end){
        if(start>end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        // BASE CASE
        // for the leaf node
        if(start==end) return node;
        int mid = start + (end-start) /2;
        node.left = buildTree(start, mid);
        node.right = buildTree(mid+1, end);
        return node;
    }
    public void update(SegmentTreeNode node, int index){
         if(node==null) return;
         // base case
        // if the start and end of the node are equal and equal to the index
        if(node.start == node.end && node.start==index){
            node.sum+=1;
            return;
        }
        int mid = node.start + (node.end - node.start)/2;
        if(index<=mid){
            update(node.left, index);
        }
        else{
            update(node.right, index);
        }
        node.sum = node.left.sum + node.right.sum;
    }
    public int sumRange(SegmentTreeNode root, int start, int end){
        // no overlap
        if(root==null || start>end) return 0;

         // complete overlap
        if(root.start  == start && root.end == end) return root.sum;
        // complete overlap in either the left or the right
        int mid = root.start + (root.end- root.start)/2;
        // check
        if(end<=mid){
            return sumRange(root.left, start, end);
        }
        else if(start>mid){
            return sumRange(root.right, start, end);
        }
        // partial overlap
        return sumRange(root.left, start, mid) + sumRange(root.right, mid+1, end);


    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums.length==0) return ans;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int ele: nums){
            min = Math.min(ele, min);
            max = Math.max(ele, max);
        }
        SegmentTreeNode root = buildTree(min, max);
        for(int i = nums.length-1; i>=0; i--){
             update(root,  nums[i]);
             ans.add(0,sumRange(root, min, nums[i]-1));
        }
        return ans;
    }
}


// --------------------------------------------------------------------------------------------
public class CountOfSmallerNumbersAfterSelf {
    public static  List<Integer> countSmallerTreeMapApproach(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>((k1, k2) -> Integer.compare(k2,k1));
        for(int i=nums.length-1; i>=0; i--){
            int count = 0;
            // get the elements that are smaller than the current number
            for(Map.Entry entry: map.tailMap(nums[i]-1).entrySet()){
                count+= (int)entry.getValue();
            }
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            ans.add(count);
        }
        return ans.reversed();
    }

    static void main() {
//        System.out.println(countSmaller(new int[]{5,2,6,1}));
    }
}
