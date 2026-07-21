import java.util.Arrays;

public class QuickSort {
    private void quickSort(int[] nums, int low, int high){
        if(low>=high) return;
        int pivot = nums[high];
        int k = low;
        for(int i= low; i < high; i++){
            if(nums[i]< pivot){
                // it should come at the kth position
                if(i!=k){
                    // swap i with k position
                    nums[i] = nums[i] ^ nums[k];
                    nums[k] = nums[i] ^ nums[k];
                    nums[i] = nums[i] ^ nums[k];
                }
                k++;
            }
        }
        // the kth position is the position of the pivot element, so swap it
        if(k!=high){
            nums[k] = nums[k] ^ nums[high];
            nums[high] = nums[k] ^ nums[high];
            nums[k] = nums[k] ^ nums[high];
        }
        quickSort(nums, low, k-1);
        quickSort(nums, k+1, high);
    }

    public  int[] quickSort(int[] nums) {
        int size =nums.length;
        quickSort(nums, 0, size-1);
        return nums;
    }

    static void main() {
        QuickSort obj = new QuickSort();
        System.out.println(Arrays.toString(obj.quickSort(new int[]{7,1,5,4,2,-1,33,2})));
    }
}
