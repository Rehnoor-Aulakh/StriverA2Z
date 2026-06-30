import java.util.*;

public class SortZeroOneTwo{
    public static void sortZeroOneTwo(int nums[]){
        //from 0 to low-1, all are 0
        //from low to mid-1, all are 1
        //from mid to high, all are unsorted
        //from high+1 to n-1, all are 2
        //we need to sort mid to high
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                //swap with low
                int t=nums[mid];
                nums[mid]=nums[low];
                nums[low]=t;
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                //swap with high
                int t=nums[high];
                nums[high]=nums[mid];
                nums[mid]=t;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int nums[]={2,0,1};
        sortZeroOneTwo(nums);
        System.out.println(Arrays.toString(nums));
    }
}