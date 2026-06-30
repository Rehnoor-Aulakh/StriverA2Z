import java.util.*;

public class NextPermutation{
    private static void reverse(int[] nums, int l, int h){
        while(l<h){
            //swap l with h
            int t=nums[l];
            nums[l]=nums[h];
            nums[h]=t;
            l++;
            h--;
        }
    }
    public static void nextPermutation(int[] nums){
        //step 1: find the pivot element
        int n= nums.length;
        int index=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            reverse(nums,0,n-1);
            return;
        }
        int maxEle=Integer.MAX_VALUE;
        int maxInd=n-1;
        for(int i=n-1;i>index;i--){
            if(nums[i]<maxEle && nums[i]>nums[index]){
                maxInd=i;
                maxEle=nums[i];
            }
        }
        //we need to swap index with the just smallest number
        int t=nums[maxInd];
        nums[maxInd]=nums[index];
        nums[index]=t;

        //now just need to reverse from index+1 to end
        reverse(nums, index+1,n-1);
    }
    public static void main(String[] args) {
        int nums[]={2,1,5,4,3,0,0};
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}