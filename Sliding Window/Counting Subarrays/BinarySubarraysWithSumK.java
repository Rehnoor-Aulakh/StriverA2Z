public class BinarySubarraysWithSumK{
    private static int subarraysSumLEGoal(int[] nums, int goal){
        if(goal<0) return 0;
        int l=0,r=0;
        int count=0;
        int sum=0;
        for(r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l++];
            }
            count+=r-l+1;
        }
        return count;
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return subarraysSumLEGoal(nums, goal)-subarraysSumLEGoal(nums, goal-1);       
    }
    public static void main(String[] args) {
        System.out.println(subarraysSumLEGoal(new int[]{1,0,1,0,1},2));
    }
}