import java.util.*;

public class SubsetsI{
    private static void generate(int i, List<Integer> ans, int[] nums, int sum){
        if(i==nums.length){
            ans.add(sum);
            return;
        }
        //recursive calls
        //include ith element
        generate(i+1, ans, nums, sum+nums[i]);
        //dont include
        generate(i+1, ans, nums, sum);
    }
    public static List<Integer> subsetSums(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int sum=0;
        generate(0,ans,nums,sum);
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={2,3};
        System.out.println(subsetSums(nums));
    }
}