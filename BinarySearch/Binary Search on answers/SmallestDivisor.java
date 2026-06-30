public class SmallestDivisor{
    private static int sumByD(int nums[], int mid){
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.ceil(nums[i]/mid);
        }
        return sum;
    }
    public static int smallestDivisor(int[] nums, int limit) {
        int n=nums.length;
        if(n>limit){
            return -1;
        }
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,nums[i]);
        }
        int low=1;
        int high=maxi;
        int ans=-1;
        while(low<=high){
            int mid=(high-low)/2+low;
            //check condition
            if(sumByD(nums,mid)<=limit){
                //go left
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
        int nums[]={1, 2, 3, 4, 5};
        System.out.println(smallestDivisor(nums, 8));
    }
}