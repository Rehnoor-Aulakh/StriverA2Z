package DP_on_Strings;

import java.lang.reflect.Array;
import java.util.Arrays;

public class WildcardMatching {
    private boolean f(String s, String p, int i, int j, int[][] dp){
        if(i<0 && j<0) return true;
        // PATTERN IS EXHAUSTED BUT STRING HAS REMAINING CHARACTERS
        if(j<0 && i>=0) return false;
        // STRING HAS EXHAUSTED BUT PATTERN HAS REMAINING CHARACTERS
        if(i<0 && j>=0){
            // then for the remaining characters, they all must be *
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*') return false;
            }
            return true;
        }

        if(dp[i][j]!=-1) return dp[i][j] ==1;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            dp[i][j]=f(s,p, i-1, j-1,dp)?1:0;
            return dp[i][j]==1;
        }
        if(p.charAt(j)=='*'){
            dp[i][j]= (f(s,p,i-1,j,dp) || f(s,p,i,j-1,dp))?1:0;
            return dp[i][j]==1;
        }
        return false;

    }
    public boolean wildCardMemoization(String s, String p) {
        int len1= s.length();
        int len2= p.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            Arrays.fill(dp[i], -1);
        }
        return f(s,p, len1-1, len2-1, dp);
    }
    public boolean wildCardTabulation(String s, String p){
        int len1= s.length();
        int len2= p.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0]=true;
        // BASE CASE 3
//        if(i<0 && j>=0){
        for(int j=1; j<=len2;j++){
            if(p.charAt(j-1)=='*'){
                // ONLY TRUE IF EVERYTHING BEFORE IT WAS ALSO A *
                dp[0][j]= dp[0][j-1];
            }
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]= dp[i-1][j-1];
                }
                if(p.charAt(j-1)=='*'){
                    dp[i][j]= dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[len1][len2];
    }
    public boolean wildCard(String s, String p){
        int len1= s.length();
        int len2= p.length();
        boolean[] prev= new boolean[len2+1];
        boolean[] curr= new boolean[len2+1];
        prev[0]=true;
        // BASE CASE 3
//        if(i<0 && j>=0){
        for(int j=1; j<=len2;j++){
            if(p.charAt(j-1)=='*'){
                // ONLY TRUE IF EVERYTHING BEFORE IT WAS ALSO A *
                prev[j]= prev[j-1];
            }
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    curr[j]= prev[j-1];
                }
                if(p.charAt(j-1)=='*'){
                    curr[j]= prev[j] || curr[j-1];
                }
            }
            prev = curr;
            curr= new boolean[len2+1];
        }
        return prev[len2];
    }

    public static void main(String[] args) {
        WildcardMatching obj = new WildcardMatching();
        System.out.println( obj.wildCard("abcasdfadsf", "**"));
    }
}
