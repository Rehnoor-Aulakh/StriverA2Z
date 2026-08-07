package FAQsMedium;
import java.util.*;

public class CombinationSumII {
    // we cant use set over here to tackle duplicates, because we would still have to generate all the combinations and addition takes logn time
    // so just avoid set -> there is an interesting approach to handle duplicates
    // we know that once we have decided to include it, there is no going back, we have to go ahead and visit all to see if the next one should be included
    // but once we decide to not include it, we can just skip this element forever, and not return to it, saving a lot of combinations
    // because include itself will handle the combinations picking the starting elements, we dont want to include the permutations of [1,1,1,2,2,2] to waste time

    private static int upperBound(int[] nums, int element, int low) {
        int n = nums.length ;
        int high = n -1;
        // the upper bound maybe the end of the array
        int candidateAns = n;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid] > element) {
                // since this is greater than the elment, this could be my answer, but go to left to see if you can do better
                candidateAns = mid;
                high = mid-1;

            } else{
                // if the middle element is smaller than the element, move right
                low = mid+1;
            }
        }
        return candidateAns;
    }
    private static void backtrack(List<List<Integer>> ans, List<Integer> t, int target, int[] nums, int i) {
        // BASE CASE
        if(target==0) {
            ans.add(new ArrayList<>(t));
            return;
        }
        if(i>=nums.length || target<0) return;
        // there is only one usage of each element, so you can either include it once, or dont include it
        t.add(nums[i]);
        backtrack(ans, t, target-nums[i], nums, i+1);
        t.remove(t.size()-1);
        /// dont include
        // find the upper bound of the element at index i
        // ignore this element
        int index = upperBound(nums, nums[i], i);
        backtrack(ans, t, target, nums, index);
    }
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t= new ArrayList<>();
        backtrack(ans, t, target, nums, 0);
        return ans;
    }
    static void main() {
        System.out.println(combinationSum2(new int[]{2, 1, 2, 7, 6, 1, 5},8));
    }
}
