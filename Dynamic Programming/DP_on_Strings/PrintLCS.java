package DP_on_Strings;

public class PrintLCS {
    public static String printLCS(String s1, String s2){
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
        int lcs= dp[len1][len2];
        StringBuilder ans= new StringBuilder();
        int i=len1,j=len2;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                //if it matches, go diagonally backwards
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else{
                // go back to the maximum of dp[i-1][j] or dp[i][j-1]
                if(dp[i-1][j]> dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }
        return ans.reverse().toString();
    }
    public static void main(String[] args) {
        String s1 = "rehnoor";
        String s2= "reno";
        System.out.println(printLCS( s1 , s2));
    }
}
