import java.util.Arrays;

public class SelectionSort {
    // This function returns the sorted array by using the selection sort algorithm
    // selection sort O(N^2)
    // this algorithm selects the smallest number at every pass and places it at the ith position
    public static int[] selectionSort(int[] nums){
        int size = nums.length;
        for(int i=0; i<size-1; i++){
            int min=nums[i];
            int minIndex=i;
            for(int j=i+1; j<size; j++){
                if(nums[j] < min){
                    min = nums[j];
                    minIndex = j;
                }
            }
            // now we need to swap the minIndex with the ith index
            /// FATAL EDGE CASE: If nums[minIndex]==nums[i], then answer would be 0
            if(minIndex != i){
                nums[minIndex] = nums[minIndex] ^ nums[i];
                nums[i] = nums[minIndex] ^ nums[i];
                nums[minIndex] = nums[minIndex] ^ nums[i];
            }
        }
        return nums;
    }

    static void main() {
        System.out.println(Arrays.toString(selectionSort(new int[]{7,1,5,3,9,2,11,4})));
    }
}
