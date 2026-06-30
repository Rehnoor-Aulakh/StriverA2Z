package DP_on_Strings;

import java.util.Arrays;

public class DistinctSubsequences {
    private int f(String s, String t, int i, int j, int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            //include or dont include
            return dp[i][j]=f(s,t, i-1,j-1, dp) + f(s,t, i-1, j, dp);
        }
        else{
            // it did not match
            return dp[i][j]=f(s,t,i-1,j, dp);
        }
    }
    public int distinctSubsequencesMemoization(String s, String t) {
        int len1= s.length();
        int len2= t.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(s,t, s.length()-1, t.length()-1, dp);
    }
    public int distinctSubsequencesTabulation(String s, String t) {
        int len1= s.length();
        int len2= t.length();
        int[][] dp = new int[len1+1][len2+1];
        //base case
        //make the first column 0
        for(int i=0;i<len1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    //include or dont include
                    dp[i][j]=dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    // it did not match
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[len1][len2];
    }
    public int distinctSubsequences(String s, String t) {
        int len1= s.length();
        int len2= t.length();
        int[] prev= new int[len2+1];
        int[] curr= new int[len2+1];
        //base case
        //make the first column 0
        prev[0]=1;
        curr[0]=1;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    //include or dont include
                    curr[j]=prev[j-1] + prev[j];
                }
                else{
                    // it did not match
                    curr[j]= prev[j];
                }
            }
            prev= curr;
            curr= new int[len2+1];
            curr[0]=1;
        }
        return prev[len2];
    }
    public static void main(String[] args) {
        DistinctSubsequences ds = new DistinctSubsequences();
        System.out.println(ds.distinctSubsequences("babgbag","bag"));

    }
}
