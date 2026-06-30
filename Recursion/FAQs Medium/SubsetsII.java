import java.util.*;

public class SubsetsII{
    private static void generate(List<List<Integer>> ans, List<Integer> t, int nums[], int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(t));
            return;
        }
        //include i
        t.add(nums[i]);
        generate(ans, t, nums, i+1);
        //backtrack
        t.remove(t.size()-1);        
        //dont include
        int index=i;
        while(index<nums.length && nums[index]==nums[i]) index++;
        generate(ans, t, nums, index);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> t=new ArrayList<>();
        generate(ans,t,nums,0);
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}