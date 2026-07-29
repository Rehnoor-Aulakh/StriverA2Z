package FAQs_Medium;

public class NextPermutation {
    private  void reverse(int[] nums, int low, int high) {
        for(int i=low; i<(high-low)/2; i++) {
            // swap nums[i] with nums[size-i-1]
            int t= nums[i];
            nums[i]= nums[high-i-1];
            nums[high-i-1] = nums[i];
        }
    }
    public void nextPermutation(int[] nums){
        if(nums.length==0 || nums.length==1) return;
        int ind = -1;
        // find the break point
        for(int i= nums.length-2 ; i>=0 ;i--) {
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }
        for(int i= nums.length-1; i>ind; i--) {
            if(nums[i]>nums[ind]) {
                // swap these
                int t = nums[i];
                nums[i] = nums[ind];
                nums[ind] = t;
                reverse(nums, ind+1, nums.length-1);
                return;
            }
        }
        if(ind == -1){
            reverse(nums, 0, nums.length-1);
        }
    }
}
