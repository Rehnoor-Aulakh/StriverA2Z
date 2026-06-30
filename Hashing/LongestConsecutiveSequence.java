
import java.util.HashSet;

public class LongestConsecutiveSequence{
    public static int longestConsecutive(int[] nums){
        HashSet<Integer> set= new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        //now iterate the array, and find the starting point
        int count=0;
        int maxCount=0;
        for(int num: set){
            //check if it is a starting point
            if(!set.contains(num-1)){
                //now check the count
                count=0;
                int j=num;
                while(set.contains(j)){
                    count++;
                    j++;
                }
                maxCount=Math.max(count,maxCount);
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        int nums[]={100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}