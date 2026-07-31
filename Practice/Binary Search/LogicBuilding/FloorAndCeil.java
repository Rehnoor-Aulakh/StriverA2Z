package LogicBuilding;

import java.nio.file.Paths;
import java.util.Arrays;

public class FloorAndCeil {
    // floor: largest element smaller than or equal to x
    // means nums[mid] <= x which is lower bound

    public int[] getFloorAndCeil(int[] nums, int x) {
        return new int[]{getFloor(nums,x), getCeil(nums, x)};
    }
    public int getFloor(int[] nums, int x) {
        int low = 0, high = nums.length-1;
        int candidateAns = -1;
        while(low<=high) {
            int mid  = low+ ((high-low)/2);
            // this is wrong because it will pick up the 0th index then
            if(nums[mid] > x) {
                // it is possible that you may find the same number on the left
                high = mid-1;
            }
            else{
                candidateAns = nums[mid];
                low = mid+1;
            }
        }
        return candidateAns;
    }
    // ceil: smallest number greater than or equal to x
    // nums[mid]>=x
    public int getCeil(int[] nums, int x) {
        int low = 0, high = nums.length-1;
        int candidateAns = -1;
        while(low <= high) {
            int mid = low+ ((high-low)/2);
            if(nums[mid]<x) {
                // go right to find a better ans
                low = mid + 1;
            }
            else {
                candidateAns = nums[mid];
                high = mid-1;
            }
        }
        return candidateAns;
    }

    static void main() {
        FloorAndCeil obj = new FloorAndCeil();
        System.out.println(Arrays.toString(obj.getFloorAndCeil(new int[]{3, 4, 4, 7, 8, 10}, 5)));
    }
}
