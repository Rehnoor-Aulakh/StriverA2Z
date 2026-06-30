public class SingleElementSortedArray{
    public static int singleNonDuplicate(int[] nums) {
        int ans=0;
        int low=0;
        int n=nums.length;
        if(n==1) return nums[0];
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
                //first check
                if(mid==0) return nums[0];
                if(mid==n-1) return nums[n-1];
                if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                    return nums[mid];
                }
                //mid is even
                //check mid+1
                if((mid%2==0 && nums[mid]==nums[mid+1]) || (mid%2!=0 && nums[mid-1]==nums[mid])){
                    //left half is alright
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            
            
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        System.out.println(singleNonDuplicate(nums));
    }
}