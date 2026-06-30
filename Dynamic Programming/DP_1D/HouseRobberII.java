package DP_1D;

public class HouseRobberII {
    private int f(int[] nums, int start , int end){
        int n = nums.length;
        int prev1= 0;
        int prev2= 0;
        prev1= nums[start];
        for(int i=start+1;i<=end;i++){
            int maxNow= Math.max(prev1, prev2+ nums[i]);
            prev2=prev1;
            prev1= maxNow;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1) return nums[0];
        return Math.max(f(nums, 0, n-2), f(nums, 1, n-1));
    }
}

