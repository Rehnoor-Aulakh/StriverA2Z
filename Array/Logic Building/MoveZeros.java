
import java.util.Arrays;

public class MoveZeros{
    public static void moveZeroesMySolution(int[] nums) {
        int noOfZeros=0;
        //first accumulate the first zero
        int i=0;
        for(;i<nums.length;i++){
            if(nums[i]==0){
                break;
            }
        }
        if(i==nums.length) return;
        //at this i, there is a zero

        for(int j=i+1;j<nums.length;j++){
            if(nums[j]==0){
                noOfZeros++;
            }
            else{
                //shift the current non-zero element left by no of zeros seen so far
                nums[j-noOfZeros-1]= nums[j];
                nums[j]=0;
 
            }
        }
    }
    public static void moveZeroesOptimal(int[] nums){
        int j;
        for(j=0;j<nums.length;j++){
            if(nums[j]==0){
                break;
            }
        }
        if(j==nums.length) return;
        //now the main iterating pointer is i
        int i=0;
        // j is at the first 0
        for(i=j+1;i<nums.length;i++){
            if(nums[i]!=0){
                //swap it with the j
                nums[j]=nums[i];
                nums[i]=0;
                j++;
            }
            
        }
    }
    public static void main(String[] args) {
        int[] arr={0,1,0,2,4,5};
        moveZeroesMySolution(arr);
        System.out.println(Arrays.toString(arr));
    }
}