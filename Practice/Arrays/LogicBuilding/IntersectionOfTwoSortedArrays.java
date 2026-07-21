package LogicBuilding;

import java.util.Arrays;

public class IntersectionOfTwoSortedArrays {
    public static int[] intersectionArray(int[] nums1, int[] nums2) {
        // first we just need to find the number of duplicate elements
        int i =0, j=0;
        int duplicates = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                duplicates++;
                i++;j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums2[j]<nums1[i]){
                j++;
            }
        }
        int ans[] = new int[duplicates];
        i=0;j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                ans[k++]= nums1[i];
                i++;j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums2[j]<nums1[i]){
                j++;
            }
        }
        return ans;
    }

    static void main() {
        System.out.println(Arrays.toString(intersectionArray(new int[]{1,2,2,3,5}, new int[]{1,2,7})));
    }
}
