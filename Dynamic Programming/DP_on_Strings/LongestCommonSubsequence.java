package DP_on_Strings;

import java.util.Arrays;

public class LongestCommonSubsequence {
    private static int f(String s1, String s2, int ind1, int ind2, int[][] dp){
        if(ind1<0 || ind2<0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        //if they match, then include 1, and move them both back
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            dp[ind1][ind2]= 1+f(s1,s2, ind1-1, ind2-1,dp);
            return dp[ind1][ind2];
        }
        //otherwise return
        dp[ind1][ind2]= Math.max(f(s1,s2, ind1-1,ind2,dp), f(s1,s2,ind1, ind2-1,dp));
        return dp[ind1][ind2];
    }
    public static int lcsMemoization( String s1, String s2) {
        int len1= s1.length();
        int len2= s2.length();
        int[][] dp = new int[len1][len2];
        for(int i=0;i<len1;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(s1,s2, len1-1, len2-1,dp);
    }
    public static int lcsTabulation(String s1, String s2){
        int len1= s1.length();
        int len2= s2.length();
        int[][] dp = new int[len1+1][len2+1];

        // 1-Indexed DP Table
        for(int ind1 = 1; ind1 <=len1; ind1++){
            for(int ind2 = 1; ind2 <=len2; ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                    dp[ind1][ind2]= 1+dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2]= Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
            }
        }
        return dp[len1][len2];
    }
    public static int lcs(String s1, String s2){
        int len1= s1.length();
        int len2= s2.length();
        int[] prev = new int[len2+1];
        int[] curr = new int[len2+1];

        // 1-Indexed DP Table
        for(int ind1 = 1; ind1 <=len1; ind1++){
            for(int ind2 = 1; ind2 <=len2; ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                    curr[ind2]= 1+prev[ind2-1];
                }
                else{
                    curr[ind2]= Math.max(prev[ind2], curr[ind2-1]);
                }
            }
            prev= curr;
            curr= new int[len2+1];
        }
        return prev[len2];
    }
    public static void main(String[] args) {
        String s1 = "rehnoor";
        String s2= "reno";
        System.out.println(lcs(s1 , s2));
    }
}
