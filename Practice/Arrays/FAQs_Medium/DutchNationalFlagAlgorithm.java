package FAQs_Medium;

public class DutchNationalFlagAlgorithm {
    // [0 to low-1](all 0s) [low to mid-1] (all 1s) [mid to high] (random 0/1/2) [high+1 to size-1](all 2s)
    // 0000000000000000000011111111111111111111111101202210120120120012221110021022222222222222222222222222
    public void sortZeroOneTwo(int[] nums) {
        int low=0, mid=0;
        int size= nums.length;
        int high = size-1;
        // mid to high we have to go
        while(mid<high) {
            if(nums[mid]==0) {
                // swap this with nums[low] because 0 to low-1 is already 0, so this would grow
                int t= nums[mid];
                nums[mid] = nums[low];
                nums[low] = t;
                low++;
                // and this would be definitely one, so it would mix in with mid-1
                mid++;
            }
            else if(nums[mid]==1) continue;
            else{
                // it is 2
                // so we need to swap mid with high
                int t = nums[mid];
                nums[mid] = nums[high];
                nums[high] = t;
                high--;
            }
        }
    }
}
