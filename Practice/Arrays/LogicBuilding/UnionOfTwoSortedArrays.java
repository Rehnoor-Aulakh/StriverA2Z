package LogicBuilding;

import java.util.Arrays;

public class UnionOfTwoSortedArrays {
    public static int[] unionArray(int[] nums1, int[] nums2) {
        // we will avoid the approach of using list and then converting it to array, in one loop we can find the size of array
        // just one bug remaining
        int i = 0, j=0;
        int size= 0;
        while(i<nums1.length && j<nums2.length){
            if(i>0 && nums1[i]==nums1[i-1]){
                i++;
                continue;
            }
            if(j>0 && nums2[j]==nums2[j-1]){
                j++;
                continue;
            }
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums2[j]<nums1[i]){
                j++;
            }
            else{
                // when both are equal, you just increase size by 1
                i++;
                j++;
            }
            size++;
        }
        // nums1 1 2 4 5 8
        // nums2 2 3 4 5 6 7 9
        // size -> 1+ 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1
        // this should work
        // this is correct now
        while(i<nums1.length){
            if(i>0 && nums1[i]==nums1[i-1]){
                i++;
                continue;
            }
            size+=1;
            i++;
        }
        while(j<nums2.length){
            if(j>0 && nums2[j]==nums2[j-1]){
                j++;
                continue;
            }
            j++;
            size+=1;
        }
        System.out.println(size);
        int[] ans = new int[size];
        // size is correct now, issue in the second iteration
        i=0;j=0;
        int k= 0;
        // same logic here
        while(i<nums1.length && j<nums2.length){
            if(i>0 && nums1[i]==nums1[i-1]){
                i++;
                continue;
            }
            if(j>0 && nums2[j]==nums2[j-1]){
                j++;
                continue;
            }
            if(nums1[i]<nums2[j]){
                ans[k++] = nums1[i++];
            }
            else if(nums2[j]<nums1[i]){
                ans[k++]= nums2[j++];
            }
            else{
                ans[k++]= nums1[i];
                // when both are equal, you just increase size by 1
                i++;
                j++;
            }

        }
        while(i<nums1.length){
            if(i>0 && nums1[i]==nums1[i-1]){
                i++;
                continue;
            }
            ans[k++]= nums1[i++];
        }
        while(j<nums2.length){
            if(j>0 && nums2[j]==nums2[j-1]){
                j++;
                continue;
            }
            ans[k++] =  nums2[j++];
        }
        return ans;
    }

    static void main() {
        System.out.println(Arrays.toString(unionArray(new int[]{1,2,3,4,5}, new int[]{1,2,7})));
    }
}
