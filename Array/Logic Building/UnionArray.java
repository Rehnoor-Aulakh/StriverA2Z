
import java.util.*;

public class UnionArray{
    public static int[] unionArray(int[] nums1, int[] nums2){
        int i=0,j=0;
        List<Integer> ans= new ArrayList<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                 if(ans.isEmpty() || ans.get(ans.size()-1)!=nums2[j]){
                    ans.add(nums2[j]);
                } 
                    j++;i++;
            }
            else if(nums1[i]<nums2[j]){
                //handle duplicates
                if(ans.isEmpty() || ans.get(ans.size()-1)!=nums1[i]){
                    ans.add(nums1[i]);
                }                
                    i++;
            }
            else if(nums2[j]<nums1[i]){
                if(ans.isEmpty() || ans.get(ans.size()-1)!=nums2[j]){
                    ans.add(nums2[j]);
                } 
                    j++;
            }
        }
        while(i<nums1.length){
            if(ans.isEmpty() || ans.get(ans.size()-1)!=nums1[i]){
                    ans.add(nums1[i]);
                }   
                    i++;
        }
        while(j<nums2.length){
             if(ans.isEmpty() || ans.get(ans.size()-1)!=nums2[j]){
                    ans.add(nums2[j]);
                } 
                    j++;
        }
        //convert array list back to array
        int size=ans.size();
        int finalAns[]= new int[size];
        int k=0;
        for(int p: ans){
            finalAns[k++]=p;
        }
        return finalAns;
    }
    public static void main(String[] args) {
        int nums1[]={3, 4, 6, 7, 9, 9};
        int nums2[]={1, 5, 7, 8, 8};
        System.out.println(Arrays.toString(unionArray(nums1, nums2)));
    }
}