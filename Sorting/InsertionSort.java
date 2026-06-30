
import java.util.*;

public class InsertionSort{
    public static int[] insertionSort(int[] nums){
        int size=nums.length;
        for(int i=1;i<size;i++){
            for(int j=i;j>0;j--){
                //keep on comparing j and j-1
                if(nums[j]<nums[j-1]){
                    //swap
                    int t=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=t;
                }
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int arr[]={5,2,3,6,1,4};
        System.out.println(Arrays.toString(insertionSort(arr)));

    }
}