public class MininumDaysBouquet{
    private static boolean check(int[] nums, int mid, int m, int k){
        //check if by waiting mid number of days, it is possible to create m bouquets of k adjacent flowers
        int bouquets=0;
        int flowers=0;
        for(int num: nums){
            if(num<=mid){
                flowers++;
                if(flowers==k){
                    bouquets++;
                    flowers=0;
                    //reset to avoid overlaps
                }
            }
            else{
                flowers=0;
                //break adjacency
            }
        }
        return bouquets>=m;
    }
    public static int minDays(int[] nums, int m, int k) {
        if(m*k > nums.length) return -1;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int num: nums){
            low=Math.min(low,num);
            high=Math.max(high, num);
        }
        int ans=-1;
        while(low<=high){
            int mid=(high-low)/2 + low;
            if(check(nums, mid, m,k)){
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
        int bloomDay[]={7,7,7,7,12,7,7};
        System.out.println(minDays(bloomDay, 2, 3));
    }
}