import java.util.*;

public class CombinationSumII{
    @SuppressWarnings("UnnecessaryReturnStatement")
    private static int upperBound(int[] nums, int target){
        int low=0;
        int ans=nums.length;
        int high=ans-1;
        while(low<=high){
            int mid=(low+high)/2;
            //i want the smallest
            //go left
            if(nums[mid]>target){
                //this is a candidate
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private static void generate(List<List<Integer>> ans, List<Integer> t, int[] nums, int target, int i){
        if(target==0){
            ans.add(new ArrayList<>(t));
            return;
        }
        if(i==nums.length || target<0) return;
        //include
        t.add(nums[i]);
        generate(ans,t,nums,target-nums[i],i+1);
        //dont include it anytime
        int index=upperBound(nums, nums[i]);
        t.remove(t.size()-1);
        //we should use binary search to optimize finding the index
        //we are trying to find the upper bound of nums[i] in nums
        generate(ans, t, nums, target, index);
        
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> t= new ArrayList<>();
        generate(ans, t, candidates, target, 0);
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={1,2,2,2,5};
        int target=5;
        System.out.println(combinationSum2(nums, target));
    }
}