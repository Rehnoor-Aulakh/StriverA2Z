package FAQsMedium;
import java.util.*;

public class CombinationSum {
    private static void backtrack(List<List<Integer>> ans, List<Integer> t, int target, int[] nums, int i) {
        // BASE CASE
        if(target==0) {
            ans.add(new ArrayList<>(t));
            return;
        }
        if(i>=nums.length || target<0) return;
        // generate all combinations
        // include this element or not include this element
        // you can include an element as many times as you want
        //  include -> i will remain at this position, and dont include will take case of moving i forward
        t.add(nums[i]);
        backtrack(ans, t, target-nums[i], nums, i);
        t.remove(t.size()-1);
        /// dont include
        backtrack(ans, t, target, nums, i+1);
    }
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        // since a sequence can be generated as many times, no need to create a set because the elements are distinct
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t= new ArrayList<>();
        backtrack(ans, t, target, nums, 0);
        return ans;
    }

    static void main() {
        System.out.println(combinationSum(new int[]{2, 3, 5, 4},7));
    }
}
