
import java.util.Arrays;



public class KadaneAlgorithm{

    public static int maxSubArrayKadane(int[] nums){
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            maxi=Math.max(sum,maxi);
            if(sum<0){
                sum=0;
            }
        }
        return maxi;
    }
    public static int[] maxSubArrayKadanePrintSubarray(int[] nums){
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        int ansStart=-1;
        int ansEnd=-1;
        int tempStart=-1;
        for(int i=0;i<nums.length;i++){
             if(sum==0){
                tempStart=i;
            }
            sum+=nums[i];
            if(sum>maxi){
                maxi=sum;
                ansStart=tempStart;
                ansEnd=i;
            }
            if(sum<0){
                sum=0;
            }
           
        }
        if(ansStart==-1 || ansEnd==-1) return null;
        else return Arrays.copyOfRange(nums, ansStart, ansEnd+1);
    }

    public static int maxSubArrayBetter(int[] nums){
        int maxi=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=0;
            //we need to find sum from i till j
            for(int j=i;j<n;j++){
                sum+=nums[j];
                maxi=Math.max(maxi,sum);
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int nums[]={2, 3, 5, -2, 7, -4};
        System.out.println(maxSubArrayKadane(nums));
        System.out.println(Arrays.toString(maxSubArrayKadanePrintSubarray(nums)));
    }
}