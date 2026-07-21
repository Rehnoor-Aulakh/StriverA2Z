import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] nums) {
        int size = nums.length;
        for(int i=0; i<size-1; i++){
            for(int j=0; j<size-1-i; j++){
                if(nums[j]>nums[j+1]){
                    // if it is strictly smaller, then only swap
                    nums[j] = nums[j]^nums[j+1];
                    nums[j+1] = nums[j]^nums[j+1];
                    nums[j] = nums[j]^nums[j+1];
                }
            }
        }
        return nums;
    }

    static void main() {
        System.out.println(Arrays.toString(bubbleSort(new int[] {7 ,4 ,1 ,5 ,3})));
    }
}
