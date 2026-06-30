public class KokoEatingBananas{
    private static int sumByK(int[] nums, int k){
        int sum=0;
        for(int num: nums){
            sum+=Math.ceil((double)num/k);
        }
        return sum;
    }
    public static int minimumRateToEatBananas(int[] nums, int h) {
        int low=1;
        //find the maximum from the array
        int maxi=Integer.MIN_VALUE;
        for(int num: nums){
            maxi=Math.max(maxi,num);
        }
        int high=maxi;
        int ans=0;
        while(low<=high){
            int mid=(high-low)/2+low;
            //apply the formula sum(piles/k)<=h
            if(sumByK(nums, mid)<=h){
                //this is a candidate
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
        int[] nums={7, 15, 6, 3};
        System.out.println(minimumRateToEatBananas(nums, 8));
    }
}