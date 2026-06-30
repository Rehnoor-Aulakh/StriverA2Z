package DP_on_Strings;

import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;

public class RegularExpressionMatching {
    private boolean f(String s, String p, int i, int j, int[][] dp){
        if(i<0 && j<0) return true;
        // if string s is empty but p has characters, then they must be all *s
        if(j<0 && i>=0) return false;
        if(j>=0  && i<0){
            //there should be alternating *
            boolean flag= true;
            while(j>=0){
                if(p.charAt(j)!='*' && flag){
                    return false;
                }
                j--;
                flag=!flag;
            }
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1;
        // this remains same
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
            dp[i][j] = f(s,p,i-1,j-1,dp)?1:0;
            return dp[i][j]==1;
        }
        if(p.charAt(j)=='*'){
            // then s.charAt(i) must match p.charAt(j)
            if(j-1<0) return false;
            boolean zeroOccurances = f(s,p, i, j-2, dp);
            boolean moreOccurances = false;
            if(s.charAt(i)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                moreOccurances= f(s,p, i-1, j, dp);
            }
            dp[i][j] = (moreOccurances || zeroOccurances) ?1:0;
            return moreOccurances|| zeroOccurances;
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        int len1= s.length();
        int len2= p.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(s,p, s.length()-1, p.length()-1,dp);
    }

    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();
        System.out.println( obj.isMatch("aab","c*a*b"));
    }
}
