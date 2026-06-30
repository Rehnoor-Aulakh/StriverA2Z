public class UpperBound{
    public static int upperBound(int[] nums, int x){
        int ans=nums.length-1;
        int high=ans, low=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>x){
                //it might be possible to reduce this, so go left
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={1,2,2,3};
        System.out.println(upperBound(nums, 2));
    }
}