import java.util.*;

public class CombinationSum{
    private static void generate(List<List<Integer>> ans, List<Integer> t, int[] nums, int target, int i){
        if(target==0){
            ans.add(new ArrayList<>(t));
            return;
        }
        if(target<0 || i==nums.length) return;
        //include i
        t.add(nums[i]);
        generate(ans, t,nums,target-nums[i],i);
        //move forward
        t.remove(t.size()-1);
        generate(ans, t, nums, target, i+1);

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> t= new ArrayList<>();
        generate(ans, t, candidates, target, 0);
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={2, 3, 5, 4};
        int target=7;
        System.out.println(combinationSum(nums, target));
    }
}