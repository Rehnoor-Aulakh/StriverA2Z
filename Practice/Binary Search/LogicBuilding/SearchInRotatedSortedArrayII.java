package LogicBuilding;

public class SearchInRotatedSortedArrayII {
    public boolean searchInARotatedSortedArrayII(int[] nums, int k) {
        // similar to rotated sorted array I, just here return true if you find k
        int  low = 0, high = nums.length-1;
        while(low<=high) {
            int mid= low + (high-low)/2;
            // either the left half will be completely sorted or the right half will be sorted
            if(nums[mid] ==k){
                return true;
            }
            if(nums[low]==nums[mid] && nums[mid]==nums[high]) {
                low++;
                high--;
                continue;
            }
            if(nums[low] <= nums[mid] && nums[low]<=k && k<=nums[mid]) {
                // k lies in between low and mid
                // go left
                high = mid-1;
            }
            // left half is sorted but k does not lie there-> go right
            else if(nums[low] <= nums[mid]) {
                low = mid+1;
            }
            else if(nums[mid] <= nums[high] && nums[mid] <=k && k<= nums[high]) {
                // the right half is sorted and k lies in right half
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }


}
