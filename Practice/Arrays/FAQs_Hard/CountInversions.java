package FAQs_Hard;

public class CountInversions {
    long ans = 0;
    private int[] merge(int[] arr1, int[] arr2) {
        // first count the inversions in this part
        int len1 = arr1.length, len2= arr2.length;
        int i=0, j=0;
        int[] ans = new int[len1 + len2];
        int k =  0;
        // count step
        while(i<len1 && j<len2) {
            if(arr1[i]<=2*arr2[j]) {
                // no inversion
                i++;
            }
            else{
                // there are inversions, the ith position and all till len1 are greater than arr2[j]
                this.ans+=(len1-i);
                j++;
            }
        }



        // merge step
        i=0;j=0;
        while(i<len1 && j<len2) {
            if(arr1[i]<=arr2[j]){
                ans[k++] = arr1[i++];
            }
            else{
                ans[k++] = arr2[j++];
            }
        }
        // if one of the array exhausts
        while(i<len1) {
            ans[k++] = arr1[i++];
        }
        while(j<len2) {
            ans[k++] = arr2[j++];
        }
        return ans;
    }
    private int[] split(int[] nums, int low, int high) {
        if(low==high) return new int[]{nums[low]};
        int mid = (low+high)/2;
        int[] left = split(nums, low, mid);
        int[] right = split(nums,mid+1, high);
        int[] merged = merge(left, right);
        return merged;
    }
    public  long numberOfInversions(int[] nums) {
        // split the array recursively
        int len = nums.length;
        split(nums, 0, len-1);
        return this.ans;
    }
}
