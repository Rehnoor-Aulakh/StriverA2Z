package FAQsMedium;
import java.util.*;
public class Subsets1 {
    private static void generate(List<Integer> ans, int sum, int[] nums, int i) {
        // at any instant , you can either include the ith element, or dont include it
        ///  OUT OF BOUNDS CASE
        if(i<0 || i>nums.length) {
            return;
        }
        // when you reach the last element, only then add
        if(i==nums.length) {
            ans.add(sum);
            return;
        }
            ///  DONT INCLUDE
            generate(ans, sum, nums, i+1) ;
            ///  INCLUDE
            generate(ans, sum+nums[i], nums, i+1);


    }
    public static List<Integer> subsetSums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        generate(ans, 0, nums,0);
        return ans;
    }

    static void main() {
        System.out.println(subsetSums(new int[]{2,3}));
    }
}
