
import java.util.HashMap;

public class LongestSubarraySumK{
    public static int longestSubarrayOptimalForPositives(int[] nums,int k){
        int sum=0;
        int left=0;
        int right=0;
        int maxLen=0;
        while(right<nums.length && left<=right){
            sum+=nums[right];
            //shrink window
            while(sum>k && left<=right){
                //remove the last number
                sum-=nums[left++];
            }
            if(sum==k){
                //add it to the solution
                maxLen=Math.max(maxLen, right-left+1);
            }
            right++;
        }
        return maxLen;
    }
    public static int longestSubarrayBetter(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum=0;
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            if(prefixSum==k){
                maxLen=Math.max(maxLen, i+1);
            }
            if(map.containsKey(prefixSum-k)){
                maxLen=Math.max(maxLen, i-map.get(prefixSum-k));
            }
            //Handle zeros, only put if sum is different
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
            //if this sum-k is in map, find its len
            
        }
        return maxLen;
    }

    public static int longestSubarrayBrute(int[] nums, int k){
        int maxi=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==k){
                    maxi=Math.max((j-i+1),maxi);
                    break;
                }    
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3,1,1,1,1,3,3};
        System.out.println(longestSubarrayOptimalForPositives(nums, 6));

    }
}