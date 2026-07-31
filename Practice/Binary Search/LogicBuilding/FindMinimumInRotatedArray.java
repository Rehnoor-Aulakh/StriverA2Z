package LogicBuilding;

import java.util.ArrayList;

public class FindMinimumInRotatedArray {
    public int findMin(ArrayList<Integer> arr) {
        int size = arr.size();
        int low = 0, high= size-1;
        int candidateMin  = Integer.MAX_VALUE;
        while(low<=high) {
            int mid = low + (high - low)/2;
            // if the left half is sorted, then the minimum will be arr[low] or go to right half to find the other half
            if(arr.get(low) == arr.get(mid) && arr.get(mid) == arr.get(high)) {
                candidateMin = Math.min(candidateMin, arr.get(mid));
                low++;
                high--;
                continue;
            }
            if(arr.get(low) <= arr.get(mid)) {
                candidateMin = Math.min(  arr.get(low), candidateMin);
                low = mid+1;
            }
            else if(arr.get(mid) <= arr.get(high)) {
                candidateMin = Math.min(candidateMin,arr.get(mid));
                high = mid-1;
            }

        }
        return candidateMin;
    }
}
