import java.util.*;

public class FourSum{
    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        // i,j,k,l
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum=(long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        List<Integer> temp= new ArrayList<>(List.of(nums[i],nums[j],nums[k],nums[l]));
                        ans.add(temp);
                        //move k and l to their correct positions
                        while(k<l && (k+1<n) && nums[k]==nums[k+1]) k++;
                        while(k<l && (l-1>k) && nums[l]==nums[l-1]) l--;
                        k++;
                        l--;
                    }
                    else if(sum<target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(nums,-294967296));
    }
}