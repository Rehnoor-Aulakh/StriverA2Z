package LIS;
import java.util.*;

public class LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> ans= new ArrayList<>();
        if(len==0) return ans;
        int[] dp = new int[len];
        int[] indexes = new int[len];
        Arrays.fill(dp,1);
        for(int i=0;i<len;i++){
            indexes[i]=i;
        }
        int maxCount=1;
        int maxIndex=0;
        for(int ind=1;ind<len;ind++){
            for(int prev_ind=0; prev_ind<ind; prev_ind++){
                //if the prev_ind is divisible by the current index, then we can include it
                if(nums[ind]%nums[prev_ind]==0){
                    //and it should be larger
                    if(dp[prev_ind]+1>dp[ind]){
                        dp[ind]= dp[prev_ind]+1;
                        //update the indexes array
                        indexes[ind]= prev_ind;
                    }
                }
            }
            //update the maxCount
            if(dp[ind]>maxCount){
                maxCount= dp[ind];
                maxIndex= ind;
            }
        }
        //now backtrack to build the answer array
        int index = maxIndex;
        while(indexes[index]!= index){
            ans.add(nums[index]);
            index= indexes[index];
        }
        ans.add(nums[index]);
        Collections.reverse(ans);
        return ans;
    }

    private static void f(int[] nums, List<Integer> curr, int i, List<Integer> result, int[] dp){

        if(i>=nums.length){
            if(curr.size()>result.size()){
                result.clear();
                result.addAll(curr);
            }
            return;
        }
        f(nums, curr, i+1, result,dp);
        //if it is divisible by the last element of curr, then only include it
        if((curr.isEmpty() || nums[i] % curr.get(curr.size()-1)==0 ) && (dp[i]<curr.size() +1)){
            dp[i]= curr.size()+1;
            curr.add(nums[i]);
            f(nums, curr,i+1 , result,dp);
            curr.remove(curr.size()-1);
        }
    }
    public List<Integer> largestDivisibleSubsetMemoization(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr= new ArrayList<>();
        List<Integer> result= new ArrayList<>();
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        f(nums, curr, 0, result, dp);
        return result;

    }

}
