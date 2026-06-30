package DP_on_Strings;

public class LongestCommonSubstring {
    public static int longestCommonSubstrTabulation(String str1, String str2) {
        int len1= str1.length();
        int len2= str2.length();
        // CONVERT THIS TO 1 BASED INDEXING
        int[][] dp = new int[len1+1][len2+1];
        int maxi = 0;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                    maxi = Math.max(maxi, dp[i][j]);
                }
            }
        }
        return maxi;
    }
    public static int longestCommonSubstr(String str1, String str2){
        int len1= str1.length();
        int len2= str2.length();
        // CONVERT THIS TO 1 BASED INDEXING
        int[] prev = new int[len2+1];
        int[] curr = new int[len2+1];
        int maxi = 0;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    curr[j]= 1+ prev[j-1];
                    maxi = Math.max(maxi, curr[j]);
                }
            }
            prev = curr;
            curr= new int[len2+1];
        }
        return maxi;
    }

    public static void main(String[] args) {
        String s1= "abcd";
        String s2= "abzd";
        System.out.println(longestCommonSubstr(s1, s2));
    }

}
