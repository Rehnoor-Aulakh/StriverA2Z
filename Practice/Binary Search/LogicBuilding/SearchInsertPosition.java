package LogicBuilding;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        // if target is found, then return that directly
        // otherwise find the candidate which is just the greater than it, means upper bound
        // if I call the upper bound function, and check the index-1 of it
        int upperBound = upperBound(nums, target);
        if(upperBound-1>=0 && nums[upperBound-1]==target) {
            return upperBound-1;
        }
        return upperBound;
    }
    public int upperBound(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        int candidateAns = -1;
        while(low<=high) {
            int mid = low + ((high-low)/2);
            if(nums[mid] <= x) {
                // definitely this is not the answer, you have to go right
                low = mid+1;
            }
            else {
                // nums[mid]>x
                candidateAns = mid;
                // go left to see if you can do better
                high = mid-1;
            }
        }
        return candidateAns==-1? nums.length : candidateAns;
    }
}
