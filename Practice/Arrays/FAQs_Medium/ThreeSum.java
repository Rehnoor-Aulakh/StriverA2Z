package FAQs_Medium;
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // first sort the array in increasing order, so that we dont have to worry about duplicates
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n-2; i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum==0){
                    ans.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    // skip duplicates for j and k and move ahead
                    while(j<k && nums[j]==nums[j+1]) {
                        j++;
                    }
                    while(j<k && nums[k]==nums[k-1]){
                        k--;
                    }
                    j++;k--;
                }
                else if(sum<0){
                    // you need to increase j
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return ans;
    }
}
