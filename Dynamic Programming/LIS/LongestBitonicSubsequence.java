package LIS;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public int LongestBitonicSequence(int[] arr) {
        int len = arr.length;
        int[] dp1= new int[len];
        int[] dp2= new int[len];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        //fill the LIS
        for(int ind = 1; ind <len; ind++){
            for(int prev_ind=0; prev_ind<ind;prev_ind++){
                if(arr[ind]>arr[prev_ind] && dp1[ind]<dp1[prev_ind]+1){
                    dp1[ind]= dp1[prev_ind]+1;
                }
            }
        }
        for(int ind= len-2;ind>=0;ind--){
            for(int prev_ind=len-1; prev_ind>ind; prev_ind--){
                //check it should be increasing from backward
                //means prev_ind must be smaller than ind
                if(arr[prev_ind]<arr[ind] && dp2[ind]<dp2[prev_ind]+1){
                    dp2[ind]= dp2[prev_ind]+1;
                }
            }
        }
        //combine the results
        int maxi=0;
        for(int i=0;i<len;i++){
            maxi = Math.max(maxi, dp1[i]+dp2[i]-1);
        }
        return maxi;

    }
}
