import java.util.Arrays;

public class InsertionSort {
    public static int upperBound(int[] nums, int x, int low, int high){
        int ans = high+1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>x){
                //it might be possible to reduce this, so go left
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int[] insertionSort(int[] nums){
        int size = nums.length;
        for(int i = 1; i<size; i++){
            int key = nums[i];
            // the upper bound is the index which is the correct position of this key
            int ind = upperBound(nums, key, 0, i);
            // swap nums[ind] with nums[i]
            if(ind!=i){
                nums[ind]= nums[ind]^nums[i];
                nums[i]= nums[ind]^nums[i];
                nums[ind]= nums[ind]^nums[i];
            }
        }
        return nums;
    }

    static void main() {
        System.out.println(Arrays.toString(insertionSort(new int[]{7,4,1,5,3,11,2,9,17,5})));
    }
}
