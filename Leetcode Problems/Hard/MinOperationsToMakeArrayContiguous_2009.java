package Hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MinOperationsToMakeArrayContiguous_2009 {
    public static int minOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int n = nums.length;
        int size = set.size();
        int[] arr = new int[size];
        // for every element in set
        int i=0;
        for(Integer num: set) {
            arr[i++]= num;
        }
        Arrays.sort(arr);
        // iterate the arr, need to check what happens when nums[i] is left, need to figure out what the right must be and how many are already sorted
        int mini = Integer.MAX_VALUE;
        for(i=0; i<arr.length; i++) {
            int left = arr[i];
            int right = left + n - 1;
            // binary search to find the index where it exceeds right, i.e. the upper bound
            int index = upperBound(arr, right);
            int validCount = index - i + 1;
            // the number of operations required are target-index
            mini = Math.min(mini, n-validCount);

        }
        return mini;
    }
    private static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        int candidateAns = high;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(arr[mid] <= target) {
                candidateAns = mid;
                // go left to see if you can find a better answer
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return candidateAns;
    }

    static void main() {
        System.out.println(minOperations(new int[]{1,10,100,1000}));
    }
}
