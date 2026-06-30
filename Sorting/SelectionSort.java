
import java.util.Arrays;

public class SelectionSort{
    public static int[] selectionSort(int[] nums){
        //in the first pass we select the smallest number and assign it to position i, and we keep on doing this
        //i's loop is for pass and denoting which element we are sorting, j's loop is for selecting the smallest element
        int size=nums.length;
        int i,j;
        int minPos;
        int min;
        for(i=0;i<size;i++){
            min=nums[i];
            minPos=i;
            for(j=i;j<size;j++){
                if(min>nums[j]){
                    min=nums[j];
                    minPos=j;
                }
            }
            //after finding the minimum element, swap minPos element with i
            int t=nums[i];
            nums[i]=nums[minPos];
            nums[minPos]=t; 
        }
        return nums;
    }
    public static void main(String[] args) {
        int arr[]={5,2,3,6,1,4};
        System.out.println(Arrays.toString(selectionSort(arr)));

    }
}