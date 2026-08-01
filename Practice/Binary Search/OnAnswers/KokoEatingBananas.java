package OnAnswers;

public class KokoEatingBananas {
    private long countHours(int[] nums, int k) {
        long sum  = 0;
        for(int num: nums) {
            sum+= Math.ceil((double)num/(double)k);
        }
        return sum;
    }
    public int minimumRateToEatBananas(int[] nums, int h) {
        // so the solution is really simple binary search, the koko can eat 1 banana per hour minimum and max(nums) banana per hour maximum
        // and we need to be as close to minimum k as possible
        int low = 1;
        int maxi = Integer.MIN_VALUE;
        for(int num: nums) {
            maxi = Math.max(maxi, num);
        }
        int high = maxi;
        while(low<=high) {
            int mid = low + (high - low)/2;
            // try to eat all bananas with mid bananas per hour speed, and we want the slowest speed possible
            if(countHours(nums, mid)<=h) {
                // you can decrease the speed of eating
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}
