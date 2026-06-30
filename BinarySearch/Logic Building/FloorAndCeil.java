
import java.util.Arrays;

public class FloorAndCeil{
    private static int getFloor(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<=target){
                ans=nums[mid];
                //go right
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    private static int getLowerBound(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=target){
                //store it in answer and go left
                ans=nums[mid];
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int[] getFloorAndCeil(int[] nums, int target){
        int[] result=new int[2];
        //Ceil is the same as lower bound
        result[0]=getFloor(nums, target);
        result[1]=getLowerBound(nums, target);
        return result;
    }
    public static void main(String[] args) {
        int[] nums={2, 4, 6, 8, 10, 12, 14};
        System.out.println(Arrays.toString(getFloorAndCeil(nums, 1)));
    }
}