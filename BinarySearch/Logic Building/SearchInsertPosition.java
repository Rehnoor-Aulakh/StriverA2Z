public class SearchInsertPosition{
    public static int searchInsert(int[] arr, int target) {
        //this is same as finding the lower bound
        //if(arr[mid]>=target), return me the smallest number such that this satisfies
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=target){
                ans=mid;
                //go left
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={1,3};
        System.out.println(searchInsert(nums, 2));
    }
}