import java.util.*;

public class ThreeSumSmaller{
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length<3) return 0;
        Arrays.sort(nums);
        //keep the first element fixed
        int sum = 0;
        for(int i=0;i<nums.length-2;i++){
            sum += f(nums, i+1, target-nums[i]);
        }
        return sum;
    }
    private int f(int[] nums, int left, int target){
        int right= nums.length-1;
        int sum = 0;
        while(left<right){
            if(nums[left]+nums[right]<target){
                // all element between left and right are satisfied
                sum += right-left;
                left++;
            }
            else{
                right--;
            }
        }
        return sum;
    }
}

class ThreeSumSmallerBetter {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length<3) return 0;
        Arrays.sort(nums);
        // the first loop for the first element
        int sum=0;
        for(int i=0;i<nums.length-2; i++){
            sum += threeSumSmaller(nums, i+1, target-nums[i]);
        }
        return sum;
    }
    private int threeSumSmaller(int[] nums, int startIndex, int target){
        int sum = 0;
        // use a second loop for the second index
        for(int i=startIndex;i<nums.length-1; i++){
            int j = binarySearch(nums, i, target-nums[i]);
            sum += (j-i);
        }
        return sum;
    }
    private int binarySearch(int[] nums, int startIndex, int target){
        int left = startIndex;
        int right = nums.length-1;
        if(left>= nums.length) return startIndex-1;
        while(left<right){
            int mid= (left+right)/2;
            if(nums[mid] < target){
                // you can go right, maybe find a bigger answer
                left = mid+1;
            }
            else{
                right= mid-1;
            }
        }
        return left;
    }

    static void main() {
        ThreeSumSmaller obj = new ThreeSumSmaller();
        System.out.println(obj.threeSumSmaller(new int[]{1,2,3,4,5} , 8));
    }
}
