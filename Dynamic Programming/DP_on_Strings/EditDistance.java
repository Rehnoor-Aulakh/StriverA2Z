package DP_on_Strings;
import java.util.Arrays;

public class EditDistance {
    private int f(String s, String t, int i, int j, int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            //if it matches, then it is fine, move both ahead
            return dp[i][j]= f(s,t, i-1, j-1, dp);
        }
        else{
            //there are 3 possibilities, insert, delete or replace
            int insert = 1+f(s,t,i,j-1, dp);
            int delete = 1+f(s,t,i-1,j, dp);
            int replace = 1+f(s,t,i-1,j-1, dp);
            return dp[i][j]= Math.min(Math.min(insert,delete),replace);
        }
    }
    public int editDistanceMemoization(String s, String t) {
        int len1= s.length();
        int len2= t.length();
        int[][] dp = new int[len1][len2];
        for(int i=0;i<len1;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(s,t, len1-1, len2-1,dp);
    }
    public int editDistance(String s, String t) {
        int len1= s.length();
        int len2= t.length();
        int[][] dp = new int[len1+1][len2+1];
        //BASE CASE
//        if(i<0) return j+1;  -> MEANS FOR 1ST ROW, J+1 SHOULD BE SET
//        if(j<0) return i+1;

        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0){
                    dp[i][j]=j;
                    continue;
                }
                if(j==0){
                    dp[i][j]=i;
                    continue;
                }
                if(s.charAt(i-1)==t.charAt(j-1)){
                    //if it matches, then it is fine, move both ahead
                    dp[i][j]= dp[i-1][j-1];
                }
                else{
                    //there are 3 possibilities, insert, delete or replace
                    int insert = 1+dp[i][j-1];
                    int delete = 1+dp[i-1][j];
                    int replace = 1+dp[i-1][j-1];
                    dp[i][j]= Math.min(Math.min(insert,delete),replace);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        EditDistance obj =  new EditDistance();
        System.out.println(obj.editDistance("intention","execution"));
    }
}
