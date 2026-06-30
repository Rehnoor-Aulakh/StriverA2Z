
import java.util.Arrays;

public class BubbleSort{
    public static int[] bubbleSort(int[] nums){
        //for every pass, we need to compare j and j+1, i is for passes
        int size=nums.length;
        for(int i=0;i<size-1;i++){
            //at ith pass, i elements are sorted
            for(int j=0;j<size-i-1;j++){
                //compare jth and j+1
                if(nums[j]>nums[j+1]){
                    //swap these 2
                    int t= nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=t;
                }

            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int arr[]={5,2,3,6,1,4};
        System.out.println(Arrays.toString(bubbleSort(arr)));

    }
}