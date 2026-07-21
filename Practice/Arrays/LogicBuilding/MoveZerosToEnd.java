package LogicBuilding;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MoveZerosToEnd {
    public static void moveZeroes(int[] nums) {
        int k = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                // at the kth position
                nums[k++] = nums[i];
            }
        }
        while(k<nums.length){
            nums[k++] = 0;
        }
    }

    static void main() {
        int[] arr = new int[]{0,1,4,0,5,2};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
