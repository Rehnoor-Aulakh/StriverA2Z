import java.util.*;

public class IntersectionArray{
    public static int[] intersectionArray(int[] nums1, int[] nums2){
        List<Integer> ans= new ArrayList<>();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                ans.add(nums1[i]);
                i++;j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int size=ans.size();
        int finalAns[]= new int[size];
        int k=0;
        for(int p: ans){
            finalAns[k]=p;
            k++;
        }
        return finalAns;
    }
    public static void main(String[] args) {
        int nums1[]={1, 2, 2, 3, 5};
        int nums2[]={1, 2, 7};
        System.out.println(Arrays.toString(intersectionArray(nums1, nums2)));
    }
}