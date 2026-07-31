package Fundamentals;

public class LowerBound1 {
    // Lower Bound of x is the first and smallest number greater than or equal to x
    // arr[mid]>=x
    // Upper bound of x means x is the upper bound, so the largest number smaller than x
    // arr[mid]>x
    public static int lowerBound(int[] nums, int x) {
        int low = 0, high = nums.length -1;
        int candidateAns = -1;
        while(low<=high) {
            int mid = low + ((high-low)/2); // 2low + high-low/2 => low+high/2
            if(nums[mid] >= x) {
                // this is a candidate
                candidateAns = mid;
                // you need to move left so that you find the smallest number greater than or equal to x
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return candidateAns==-1?nums.length:candidateAns;
    }

    static void main() {
        System.out.println( lowerBound(new int[] {1,2,2,3}, 2));
    }
}
