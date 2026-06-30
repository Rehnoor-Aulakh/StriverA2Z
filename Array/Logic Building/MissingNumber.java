public class MissingNumber{
    public static int missingNumber(int[] nums){
        int len=nums.length;
        int sum=len*(len+1)/2;
        //find the currSum
        int currSum=0;
        for(int i=0;i<len;i++){
            currSum+=nums[i];
        }
        return sum-currSum;
    }
    public static int missingNumberXOR(int[] nums){
        int first=0;
        int second=0;
        int ans=0;
        int i;
        for(i=0;i<nums.length;i++){
            first=first^nums[i];
            second=second^i;
        }
        second=second^i;
        ans=first^second;
        return ans;
        
    }
    public static void main(String[] args) {
        int[] nums={0, 2, 3, 1, 4};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumberXOR(nums));

    }
}