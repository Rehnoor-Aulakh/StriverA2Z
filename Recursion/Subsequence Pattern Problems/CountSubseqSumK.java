public class CountSubseqSumK{
    private static int check(int i, int k, int[] nums){
        if(k==0) return 1;
        else if(k<0 || i==nums.length) return 0;
        //include nums[i] || dont include nums[i]
        return check(i+1, k-nums[i],nums) + check(i+1, k,nums);
    }
    public static int countSubsequenceWithTargetSum(int[] nums, int k) {
        return check(0,k,nums);
    }
    public static void main(String[] args) {
        int nums[]={1, 2, 3, 4, 5};
        int k=8;
        System.out.println(countSubsequenceWithTargetSum(nums, k));
    }
}