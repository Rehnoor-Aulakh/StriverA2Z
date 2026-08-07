package SubsequencePatternProblems;

public class CheckIfThereIsSubsequenceSumK {
    private static boolean f(int[] nums, int k, int index, int runningSum ) {
        // simple include dont include logic
        if(index ==nums.length) {
            return runningSum==k;
        }
        // otherwise play include dont include
        boolean dontInclude= f(nums, k, index + 1, runningSum);
        boolean include = f(nums, k, index + 1, runningSum+nums[index]);
        return dontInclude || include;
    }
    public static boolean checkSubsequenceSum(int[] nums, int k) {
        return f(nums, k, 0,0);
    }
    public static void main() {
        System.out.println(checkSubsequenceSum(new int[]{1,2,3,4,5}, 40));
    }
}
