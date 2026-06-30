
import java.util.Arrays;

public class RemoveDuplicatesSortedArray{
    public static int removeDuplicates(int[] nums) {
        int i;//swap postion
        //find the first duplicate
        for(i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                break;
            }
        }
        //now j will be i+1 i.e the position to be swapped
        int j=i+1;
        for( i=i+2; i<nums.length ; i++){
            if(nums[i]!=nums[i-1]){
                //swap with j
                nums[j]=nums[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }
    public static void main(String[] args) {
        int[] nums={0, 0, 3, 3, 5, 6};
        System.out.println(removeDuplicates(nums));
    }
}