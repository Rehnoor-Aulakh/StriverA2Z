package Implementation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    private static void f(List<List<Integer>> ans, List<Integer> t, int[] nums, int i) {
        if(i==nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        // at any instance, you can either include the element at index i or not include it
        // dontInclude
        f(ans, t, nums, i+1);
        // include
        t.add(nums[i]);
        f(ans, t, nums, i+1);
        t.remove(t.size()-1);
    }
    public static List<List<Integer>> powerSet(int[] nums) {
        //simple include dont include question
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length==0) return ans;
        List<Integer> t = new ArrayList<>();
        f(ans, t, nums, 0);
        return ans;
    }

    static void main() {
        System.out.println(powerSet(new int[]{1,2,3}));
    }
}
