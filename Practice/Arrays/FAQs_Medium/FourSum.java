package FAQs_Medium;
import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n-3; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j= i+1; j<n-2; j++){
                if(nums[j]==nums[j-1]) continue;
                int k = j+1;
                int l = nums.length-1;
                while(k<l){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum==target){
                        ans.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[l])));
                        // k and l should not be duplicates
                        while(k<l && nums[k]==nums[k+1]) k++;
                        while(k<l && nums[l]==nums[l-1]) l--;
                        k++; l--;
                    }
                    else if(sum< target){
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
}
