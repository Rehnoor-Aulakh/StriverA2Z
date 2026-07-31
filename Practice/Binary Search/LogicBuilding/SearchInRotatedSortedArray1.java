package LogicBuilding;

public class SearchInRotatedSortedArray1 {
    // at an unknown pivot point, the array is rotated->

    // algorithm -> first find the rotation point
    // once you have the rotation point from 0 to rotationPoint-1 is one part and rotationPoint to size-1 is the second part
    // figure out where k will lie, apply binary search on that part only
//    O(logn) to find the rotation point + O(logn) to find the kth element
    public int search(int[] nums, int k) {
        // normal binary search, just check low..mid if it is sorted and mid+1..high if it is sorted while moving
        int low = 0, high = nums.length -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]==k) return mid;
            // otherwise we need to check, if low to mid is sorted and the element lies in between it
            if(nums[low]<=nums[mid] && nums[low]<=k && k<=nums[mid]){
                // eliminate the right half
                high = mid-1;
                continue;
            }
            // left part is sorted but k lies in right half
            else if(nums[low]<=nums[mid]){
                // left side is unsorted and then check if it
                low = mid+1;
                continue;
            }
            // check if the right half is sorted and the element lies there
            else if(nums[high]>=nums[mid] && nums[mid]<=k && k<=nums[high] ){
                low = mid+1;
                continue;
            }
            else{
                high = mid-1;
            }

        }
        return -1;

    }
}
