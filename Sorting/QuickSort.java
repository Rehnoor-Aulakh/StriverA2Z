
import java.util.*;

public class QuickSort {

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = nums[high];
            //partition algo
            int pos = low - 1;
            for (int i = low; i < high; i++) {
                if (nums[i] <= pivot) {
                    pos++;
                    //swap pos with i
                    int t = nums[pos];
                    nums[pos] = nums[i];
                    nums[i] = t;
                }
            }
            //now swap pos+1 with pivot
            int t = nums[pos + 1];
            nums[pos + 1] = nums[high];
            nums[high] = t;
            //now the element at pos+1 is at its correct position, recursively sort other 2 halves
            quickSort(nums, low, pos);
            quickSort(nums, pos + 2, high);
        }

    }

    public static int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 3, 6, 1, 4};
        System.out.println(Arrays.toString(quickSort(arr)));

    }
}
