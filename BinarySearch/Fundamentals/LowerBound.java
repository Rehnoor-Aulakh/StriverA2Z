public class LowerBound{
    public static int lowerBound(int[] nums, int x){
        int ans=nums.length;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else if(nums[mid]<x){
                //go right
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={3, 4, 4, 7, 8, 10};
        int x=5;
        System.out.println(lowerBound(nums, x));

    }
}