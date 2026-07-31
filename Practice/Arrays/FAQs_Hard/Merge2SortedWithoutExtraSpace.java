package FAQs_Hard;

public class Merge2SortedWithoutExtraSpace {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n;
        int i = m;
        int j = n;
        // now compare i and j
        while(i>=0 && j>=0) {
            if(nums1[i]>=nums2[j]) {
                // then at kth position, nums1[i] will have to come
                nums1[k--]= nums1[i--];
            }
            else  {
                // then at kth position, nums2[j] will have to come
                nums1[k--] = nums2[j--];
            }
        }
        // is there any one remaining
        while(i>=0) {
            nums1[k--] = nums1[i--];
        }
        while(j>=0) {
            nums1[k--] = nums2[j--];
        }

    }
}
