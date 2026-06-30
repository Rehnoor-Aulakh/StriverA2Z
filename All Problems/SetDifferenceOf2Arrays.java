import java.util.*;

public class SetDifferenceOf2Arrays {
    public int[] setDifference(int[] nums1, int[] nums2) {
        int i=0, j=0;
        List<Integer> ans= new ArrayList<>();
        int len1= nums1.length;
        int len2= nums2.length;
        while(i<len1 && j<len2){
            // skip duplicates in nums1
            while(i>0 && i<len1 && nums1[i]==nums1[i-1]) i++;
            while(j>0 && j<len2 && nums2[j]==nums2[j-1]) j++;
            if(nums1[i]== nums2[j]){
                i++;j++;
            }
            else if(nums1[i]>nums2[j]){
                ans.add(nums2[j]);
                j++;
            }
            else{
                ans.add(nums1[i]);
                i++;
            }
        }
        // and if still some numbers are pending, just append them to ans
        while(i<len1){
            ans.add(nums1[i++]);
        }
        while(j<len2){
            ans.add(nums2[j++]);
        }
        return ans.stream().mapToInt(ind -> ind).toArray();
    }
}
