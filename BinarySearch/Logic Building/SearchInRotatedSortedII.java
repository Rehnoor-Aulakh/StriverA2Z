public class SearchInRotatedSortedII{
    public static boolean search(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target) return true;
            //check which half is sorted, and work accordingly
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                //check the one previous of mid and one next of mid to figure out where to go
                low=low+1;
                high=high-1;
                continue;

            }
            else if(nums[low]<=nums[mid]){
                //then left half is sorted
                if(nums[low]<=target && target<=nums[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(nums[mid]<=target && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int nums[]={7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        System.out.println(search(nums, 0));
    }
}