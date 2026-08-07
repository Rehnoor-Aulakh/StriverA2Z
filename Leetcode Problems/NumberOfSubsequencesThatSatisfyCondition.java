import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyCondition {
    private static final int MOD = 1000000000+7;
    public static int numSubseq(int[] nums, int target) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        // keep a left pointer and a right pointer, if the sum of left and right elements is <= target, then all the possible combinations
        // i.e 2^elements between left and right can be added
        int n = nums.length;
        int left = 0, right = n -1;
        int ans = 0;
        while(left<=right) {
            if(nums[left] + nums[right] <= target) {
                ans= (ans + (int)Math.pow(2, (right-left)))%MOD;
                left++;

            }
            // the right element is so big that it cant combine with left to form the target
            else{
                right--;
            }
        }
        return ans;
    }
    public static void main() {
        System.out.println(numSubseq(new int[]{3,5,6,7}, 9));
    }
}
