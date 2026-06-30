import java.util.*;

public class ReversePairs{
    public static int reversePairs(int[] nums){
        return mergeSort(nums, 0, nums.length-1);
    }
    //Merge Sort function
    private static int mergeSort(int[] nums, int low, int high){
        //base case
        if(low>=high) return 0;
        int mid=(low+high)/2;
        int count=0;
        count+=mergeSort(nums,low,mid);
        count+=mergeSort(nums,mid+1,high);
        count+=countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);

        return count;
    
    }
    //Count reverse pairs
    private static int countPairs(int[] nums, int low, int mid, int high){
        int right=mid+1;
        int count=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)nums[i]>2L * nums[right]){
                right++;
            }
            //when stopped
            count+=(right-(mid+1));
        }
        return count;
    }
    //merge 2 sorted halves
    private static void merge(int[] nums, int low, int mid, int high){
        List<Integer> temp= new ArrayList<>();
        int left=low, right=mid+1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left++]);
            }
            else{
                temp.add(nums[right++]);
            }
        }
        while(left<=mid) temp.add(nums[left++]);
        while(right<=high) temp.add(nums[right++]);

        for(int i=low;i<=high;i++){
            nums[i]=temp.get(i-low);
        }
    }
    public static void main(String[] args) {
        int nums[]={40,25,19,12,9,6,2};
        int ans= reversePairs(nums);
        System.out.println(ans);
    }
}