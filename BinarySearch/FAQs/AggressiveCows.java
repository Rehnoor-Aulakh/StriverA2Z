
import java.util.Arrays;

public class AggressiveCows{
    private static boolean canWePlace(int[] nums, int k, int mid){
        int count=1;
        int last=nums[0];
        //first cow at position 0
        for(int i=1;i<nums.length;i++){
            if(nums[i]-last>=mid){
                count++;
                last=nums[i];
            }
        }
        return (count>=k);

    }
    public static int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int low=1;
        int high=nums[nums.length-1]-nums[0];
        for(int num: nums){
            low=Math.min(low,num);
            high=Math.max(high,num);
        }
        int ans=-1;
        while(low<=high){
            int mid=(high-low)/2+low;
            if(canWePlace(nums,k,mid)){
                ans=mid;
                //try to increase the distance
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={4, 2, 1, 3, 6};
        System.out.println(aggressiveCows(nums, 2));
    }
}