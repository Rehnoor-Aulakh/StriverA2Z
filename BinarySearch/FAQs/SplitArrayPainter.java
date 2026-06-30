public class SplitArrayPainter{
    private static boolean check(int[] nums, int maxTime, int k){
        //mid is the time units
        //just find out the number of painters that can be allocated mid number of time units
        int timeUnits=0;
        int painters=1;
        for(int num: nums){
            if(timeUnits+num>maxTime){
                timeUnits=num;
                painters++;
                if(painters>k){
                    return false;
                }
            }
            else{
                timeUnits+=num;
            }
        }
        return true;
    }
    public static int largestSubarraySumMinimized(int[] nums, int k) {
        if(k>nums.length) return -1;
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int num: nums){
            high+=num;
            low=Math.max(num,low);
        }
        int ans=-1;
        while(low<=high){
            int mid=(high-low)/2+low;
            if(check(nums,mid,k)){
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
        int nums[]={7,2,5,10,8};
        System.out.println(largestSubarraySumMinimized(nums, 2));
    }
}