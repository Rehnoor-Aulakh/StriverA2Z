
import java.util.Arrays;

public class FirstAndLastOccurence{
    private static int firstOccurence(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=target){
                //even then go left
                if(nums[mid]==target){
                    ans=mid;
                }
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private static int lastOccurence(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<=target){
                //go right
                if(nums[mid]==target){
                    ans=mid;
                }
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static int[] searchRange(int[] nums, int target){
        int[] ans=new int[2];
        ans[0]=firstOccurence(nums,target);
        ans[1]=lastOccurence(nums,target);
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 5)));
    }
}