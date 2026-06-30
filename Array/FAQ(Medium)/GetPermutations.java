import java.util.*;

public class GetPermutations{
    public static List<List<Integer>> getPermutations(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, 0, ans);
        return ans;
    }
    private static void permute(int nums[], int ind , List<List<Integer>> ans ){
        //base case
        if(ind==nums.length){
            //your permutation is ready in nums
            //in space swapping, saves space
            List<Integer> temp = new ArrayList<>();
            for(int num: nums){
                temp.add(num);
            }
            ans.add(temp);
            return;
        }
        //recursive calls
        for(int i=ind; i<nums.length;i++){
            swap(nums,ind,i);
            permute(nums,ind+1,ans);
            //backtrack
            swap(nums,ind,i);
        }

    }
    private static void swap(int[] nums, int i, int j){
        int t= nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}