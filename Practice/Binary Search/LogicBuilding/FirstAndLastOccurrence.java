package LogicBuilding;

public class FirstAndLastOccurrence {
    // first occurrence means nums[mid]== target and go left
    public int[] searchRange(int[] nums, int target) {
        return new int[]{firstOccurrence(nums,target), lastOccurrence(nums,target)};
    }
    private int firstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int candidateAns = -1;
        while(low <= high) {
            int mid = low + ((high-low)/2);
            if(nums[mid]== target) {
                // go left
                candidateAns = mid;
                high = mid-1;
            }
            else if(nums[mid]<target ) {
                // go right
                low =  mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return candidateAns;
    }
    private int lastOccurrence(int[] nums, int target) {
        int low  = 0, high = nums.length-1;
        int candidateAns = -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]== target) {
                // go right
                candidateAns = mid;
                low = mid+1;
            }
            else if(nums[mid]<target) {
                // go right
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return candidateAns;
    }
}
