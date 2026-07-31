package Fundamentals;

public class SearchXInSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<=high) {
            int mid = (low + (high-low)) /2;
            // check whether to go left or right
            if(nums[mid]==target) {
                return mid;
            }
            if(nums[mid] < target) {
                // go right
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}
