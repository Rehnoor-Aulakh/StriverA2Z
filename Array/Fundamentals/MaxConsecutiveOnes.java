
public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        //time complexity O(n)
        //space complexity O(1)
        int max = 0;
        int currMax=0;
        boolean prevOne=false;
        if(nums[0]==1){
            prevOne=true;
            max=1;
            currMax=1;
        }
        for(int i=1;i<nums.length;i++){
            if(prevOne && nums[i]==1){
                currMax++;
            }
            else if(nums[i]==1 && !prevOne){
                prevOne=true;
                currMax=0;
                currMax++;
                // max=Math.max(max,currMax);
            }
            else if(nums[i]==0 && prevOne){
                max=Math.max(currMax,max);
                currMax=0;
            }
        }
        max=Math.max(max,currMax);

        return max;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 0, 0, 1, 1, 1, 0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
