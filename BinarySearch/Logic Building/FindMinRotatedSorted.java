public class FindMinRotatedSorted{
    public static int findMin(int[] nums){
        int min=Integer.MAX_VALUE;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            //find the sorted half
            if(nums[low]<=nums[mid]){
                //LEFT HALF SORTED
                min=Math.min(nums[low], min);
                //might be possible to reduce min by going in the unsorted half
                low=mid+1;
            }
            else{
                //RIGHT HALF SORTED
                min=Math.min(min, nums[mid]);
                high=mid-1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int nums[]={4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}