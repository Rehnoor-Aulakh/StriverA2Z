package FAQs_Hard;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n =nums.length;
        int prefix =1, suffix =1;
        int ans = Integer.MIN_VALUE;
        for(int i =0; i<n; i++) {
            // if at any moment the prefix or the suffix becomes 0, reset it
            if(prefix==0 ) prefix = 1;
            if(suffix ==0) suffix = 1;
            prefix= prefix*nums[i];
            suffix = suffix*nums[n-i-1];
            ans  = Math.max(ans, Math.max(prefix, suffix));

        }
        return ans;
    }
}
