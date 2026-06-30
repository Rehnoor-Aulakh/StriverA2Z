package LIS;

import java.util.*;

public class LongestIncreasingSubsequence {
    private int f(int[] nums, int index, int prev_index, int[][] dp){
        if(index>=nums.length){
            return 0;
        }
        if(dp[index][prev_index+1]!=-1) return dp[index][prev_index+1];
        int dontInclude = f(nums, index+1, prev_index, dp);
        int include = 0;
        if(prev_index==-1 || nums[index]>nums[prev_index]){
            include = 1+f(nums, index+1, index, dp);
        }
        return dp[index][prev_index+1] = Math.max(include, dontInclude);

    }
    public int LISMemoization(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(nums, 0, -1, dp);
    }
    public int LISTabulation(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        //now do the iteration
        for(int i=n-1; i>=0; i--){
            for(int prevInd=i-1; prevInd>=-1; prevInd--){
                int dontInclude = dp[i+1][prevInd+1];
                int include = 0;
                if(prevInd==-1 || nums[i]>nums[prevInd]){
                    include = 1+ dp[i+1][i+1];
                }
                dp[i][prevInd+1]= Math.max(include, dontInclude);
            }
        }
        return dp[0][0];

    }
    public int LIS(int[] nums){
        int n = nums.length;
        int[] prev = new int[n+1];
        int[] curr= new int[n+1];
        //now do the iteration
        for(int i=n-1; i>=0; i--){
            for(int prevInd=i-1; prevInd>=-1; prevInd--){
                int dontInclude = prev[prevInd+1];
                int include = 0;
                if(prevInd==-1 || nums[i]>nums[prevInd]){
                    include = 1+ prev[i+1];
                }
                curr[prevInd+1]= Math.max(include, dontInclude);
            }
            prev = curr;
            curr= new int[n+1];
        }
        return prev[0];

    }
    //lower bound is the smallest number greater than or equal to num
    private int lowerBound(List<Integer> arr, int num){
        int size= arr.size();
        int ans= arr.size();
        int low=0;
        int high=size-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr.get(mid)>=num){
                //this is a possible candidate
                ans=mid;
                //go left to find a better answer
                high=mid-1;
            }
            else{
                //this is not a possible answer because num is larger than current index
                //go right
                low=mid+1;
            }
        }
        return ans;
    }
    public int LISBinarySearch(int[] nums){
        List<Integer> arr= new ArrayList<>();
        int len = nums.length;
        if(len==0) return 0;
        arr.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            //if the new number is greater than the last index of arr, push it in the array
            if(nums[i]>arr.get(arr.size()-1)){
                arr.add(nums[i]);
            }
            else{
                //otherwise find the lowerbound index and replace it with current index
                int lb = lowerBound(arr, nums[i]);
                arr.set(lb, nums[i]);
            }

        }
        return arr.size();
    }
    public int LISBestApproachTabulation(int[] nums){
        int len = nums.length;
        if(len==0) return 0;
        int[] dp = new int[len];
//        int[] indexes= new int[len];
        Arrays.fill(dp,1);
        int maxCount=1;
//        int maxIndex=-1;
        for(int ind=0;ind<len;ind++){
            for(int prev_ind=0;prev_ind<ind;prev_ind++){
                //if the prev_index's value is smaller than the current index, then it is a candidate
                if(nums[prev_ind]<nums[ind]){
                    if(dp[ind]<dp[prev_ind]+1){
                        dp[ind]= dp[prev_ind]+1;
//                        indexes[ind]= prev_ind;
                        if(dp[ind]>maxCount){
                            maxCount=dp[ind];
//                            maxIndex=ind;
                        }
                    }
                }
            }
        }
        return maxCount;
    }
}
