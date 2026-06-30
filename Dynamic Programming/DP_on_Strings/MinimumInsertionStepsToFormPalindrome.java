package DP_on_Strings;

public class MinimumInsertionStepsToFormPalindrome {
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
    public int minInsertion(String s) {
        return s.length()-longestPalinSubseq(s);
    }
}
