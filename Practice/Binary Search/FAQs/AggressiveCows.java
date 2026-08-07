package FAQs;

import java.util.Arrays;

public class AggressiveCows {
    private static boolean check(int[] nums, int k, int distance) {
        int prevEle = -1;
        int count = 0;
        for(int num: nums) {
            if(count==k) return true;
            if(prevEle == -1) {
                // this is the first element, so it can be alloted a stall
                prevEle= num;
                count++;
            } else {
                // you need to check the prevEle
                if(num-prevEle >= distance) {
                    prevEle = num;
                    count++;
                }
            }
        }
        return count==k;
    }
    public static int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int low = nums[0], high =nums[nums.length-1];
        while(low<=high) {
            int mid = low + (high-low)/2;
            System.out.println(mid);
            if(check(nums, k, mid)) {
                // you may increase the distance to find an even better answer
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return high;
    }
    public static void main() {
        System.out.println(aggressiveCows(new int[]{0, 3, 4, 7, 10, 9}, 4));
    }
}
