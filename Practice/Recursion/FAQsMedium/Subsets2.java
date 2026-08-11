package FAQsMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
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
    private static void generate(List<List<Integer>> ans, List<Integer> t, int[] nums, int i) {
        if(i<0 || i>nums.length) return;
        if(i==nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        /// INCLUDE
        t.add(nums[i]);
        generate(ans, t, nums, i+1);
        t.remove(t.size()-1);

        /// DONT INCLUDE
        int index = upperBound(nums, nums[i], i);
        generate(ans, t, nums, index);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // I think we can use the same logic here of sorting the array first and going to the upper bound directly if we decide to not include the element
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t= new ArrayList<>();
        generate(ans, t, nums, 0);
        return ans;
    }

    static void main() {
        System.out.println(subsetsWithDup(new int[]{1, 3, 3}));
    }
}
