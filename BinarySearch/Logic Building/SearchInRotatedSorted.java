public class SearchInRotatedSorted{
    public static int search(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            //check which half is sorted
            int mid=(low+high)/2;
            if(nums[mid]==target) return mid;

            if(nums[low]<=nums[mid]){
                //then left half is sorted, check if target would lie here
                if(nums[low]<=target && target<=nums[mid]){
                    //go left
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                //right half is sorted
                if(nums[mid]<=target && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[]={7,8,9,1,2,3,4,5,6};
        System.out.println(search(nums, 1));
    }
}