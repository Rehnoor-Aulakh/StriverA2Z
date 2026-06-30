public class PeakElement{
    public static int findPeakElement(int[] nums) {
        int low=0;
        int n=nums.length;
        int high=n-1;
        if(high==0){
            return 0;
        }
        while(low<=high){
            int mid=(low+high)/2;
            //check
            if((mid==0 || nums[mid-1]<nums[mid]) && (mid==n-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(((mid-1)>=0 && nums[mid]>nums[mid-1]) || ((mid-1)<0 && nums[mid]<nums[mid+1])){          
                //previous is incresing
                //go right
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums={100,1,2,3,4};
        System.out.println(findPeakElement(nums));
    }
}