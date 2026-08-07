package OnAnswers;

public class MinimumDaysToMakeMBouquets {
    private static boolean check(int[] nums, int k, int m, int noOfDays) {
        int runningCount = 0;
        for(int i=0; i<nums.length; i++) {
            if(m==0) return true;
            if(nums[i]<= noOfDays) {
                runningCount++;
                if(runningCount == k) {
                    m--;
                    runningCount=0;
                }
            } else {
                runningCount = 0;
            }
        }
        return m==0;
    }
    public static int roseGarden(int n, int[] nums, int k, int m) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        // iterate the nums array to find the max and min value
        for(int num: nums) {
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
        }
        int low = mini, high = maxi;
        // now apply binary search on low and high, to find the optimal point that satisfies the condition
        while(low<=high) {
            int mid = low + (high-low)/2;
            // now you need to check if we can make m bouquets of k flowers using mid number of days
            if(check(nums, k, m, mid)) {
                // go left, you may find a better answer
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low>maxi? -1 : low;
    }
    public static void main() {
        System.out.println(roseGarden(5, new int[]{1, 10, 3, 10, 2}, 2,3));
    }
}
