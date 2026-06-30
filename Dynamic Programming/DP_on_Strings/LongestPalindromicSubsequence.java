package DP_on_Strings;

public class LongestPalindromicSubsequence {
    public static int longestPalinSubseqTabulation(String s1) {
        String s2= new StringBuilder(s1).reverse().toString();
        int len = s1.length();
        int[][] dp = new int[len+1][len+1];
        int maxi=0;
        for(int i=1;i<=len;i++){
            for(int j=1;j<=len;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    maxi = Math.max(maxi, dp[i][j]);
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return maxi;
    }
    public static int longestPalinSubseq(String s1) {
        String s2= new StringBuilder(s1).reverse().toString();
        int len = s1.length();
        int[] prev= new int[len+1];
        int[] curr= new int[len+1];
        int maxi=0;
        for(int i=1;i<=len;i++){
            for(int j=1;j<=len;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j] = 1+prev[j-1];
                    maxi = Math.max(maxi, curr[j]);
                }
                else{
                    curr[j]=Math.max(prev[j], curr[j-1]);
                }
            }
            prev= curr;
            curr= new int[len+1];
        }
        return maxi;
    }
    public static void main(String[] args) {
        String s= "bbabcbcab";
        System.out.println(longestPalinSubseq(s));
    }
}
