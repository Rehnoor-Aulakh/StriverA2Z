import java.util.*;

public class PowerSet{
    private static void generate(List<List<Integer>> ans, List<Integer> t, int index, int[] nums){
        if(index==nums.length){
            //add a copy of t, not reference of t
            ans.add(new ArrayList<>(t));
            return;
        }
        //include or dont include
        //include statement
        t.add(nums[index]);
        generate(ans, t, index+1, nums);
        //backtrack
        t.removeLast();
        //dont include
        generate(ans, t, index+1, nums);
    }
    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> t=new ArrayList<>();
        //t is for storing temporary list, which we will add to answer,when ready
        generate(ans, t, 0, nums);
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        System.out.println(powerSet(nums));
    }
}