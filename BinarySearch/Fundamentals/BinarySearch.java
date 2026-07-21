package Fundamentals;

public class BinarySearch{
    public static int binarySearch(int[] nums, int target){
       int low=0;
       int high=nums.length-1;
       while(low<=high){
        int mid=(high-low)/2 + low;
        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]<target){
            //go right
            low=mid+1;
        }
        else{
            high=mid-1;
        }
       }
       return -1;
    }
    public static int binarySearch(int[] nums, int target, int low, int high){
        //base case
        if(low>high){
            return -1;
        }
        int mid=(high-low)/2 + low;
        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]<target){
            //go right
            low=mid+1;
        }
        else{
            high=mid-1;
        }
        return binarySearch(nums,target,low,high);
    }
    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,12};
        int target=9;
        System.out.println(binarySearch(nums, target,0,nums.length-1));
    }
}