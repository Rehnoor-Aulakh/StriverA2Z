import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        int count = 0;
        int maxCount = 0;
        HashSet<Integer> set =new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        // now iterate the nums array again
        for(int num: nums) {
            // this is the starting point
            if(!set.contains(num-1)) {
                // for the starting point, we are gonna go till the end counting consecutive elements
                count = 0;
                int j = num;
                while(set.contains(j)){
                    count++;
                    j++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
