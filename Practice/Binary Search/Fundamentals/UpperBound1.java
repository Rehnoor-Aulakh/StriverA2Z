package Fundamentals;

public class UpperBound1 {
    // upper bound is the largest number smaller greater than x
//    arr[mid]>x
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
