package LogicBuilding;

import java.util.ArrayList;
import java.util.List;

public class FindOutHowManyTimesArrayIsRotated {
    public static int findKRotation(List<Integer> nums) {
        // just need to find the pivot element where the array is unsorted
        int low = 0, high = nums.size() - 1;
        int size= nums.size();
        while(low<=high) {
            int mid = low + (high-low)/2;
            // base case
            if((mid>0 && nums.get(mid)<nums.get(mid-1))) {

                return mid;
            }
            if(mid<size-1 && nums.get(mid)>nums.get(mid+1)){
                return mid+1;
            }
            if(nums.get(low) <= nums.get(mid)) {
                // then the left half is sorted, need to check right
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return 0;
    }

    static void main() {
        List<Integer> arr = List.of(1,23,3);
        System.out.println(findKRotation(List.of(4, 5, 6, 7, 0, 1, 2, 3)));
    }
}
