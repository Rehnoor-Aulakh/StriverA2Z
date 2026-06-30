package LIS;

import java.util.*;

public class PrintLIS {
    public List<Integer> longestIncreasingSubsequence(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(len==0) return ans;
        int[] dp = new int[len];
        int[] indexes= new int[len];
        for(int i=0;i<len;i++){
            indexes[i]=i;
        }
        Arrays.fill(dp,1);
        int maxCount=1;
        int maxIndex=0;
        for(int ind=0;ind<len;ind++){
            for(int prev_ind=0;prev_ind<ind;prev_ind++){
                //if the prev_index's value is smaller than the current index, then it is a candidate
                if(nums[prev_ind]<nums[ind]){
                    if(dp[ind]<dp[prev_ind]+1){
                        dp[ind]= dp[prev_ind]+1;
                        indexes[ind]= prev_ind;

                    }

                }
            }
            if(dp[ind]>maxCount){
                maxCount=dp[ind];
                maxIndex=ind;
            }
        }
        int index= maxIndex;
        while(indexes[index]!=index){
            ans.add(nums[index]);
            index = indexes[index];
        }
        ans.add(nums[index]);
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        PrintLIS printer = new PrintLIS();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(printer.longestIncreasingSubsequence(nums));
        // Output: [2, 3, 7, 101] or [2, 5, 7, 101] or [2, 3, 7, 18] etc.
    }
}
