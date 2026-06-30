package DP_on_Strings;

public class ShortestCommonSupersequence {
    public static String shortestCommonSupersequence(String s1, String s2) {
        int len1= s1.length();
        int len2= s2.length();
        int[][] dp = new int[len1+1][len2+1];
        // 1 BASED INDEXING IN DP ARRAY, 0 BASED INDEXING IN STRING
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]= 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder ans= new StringBuilder();
        int i=len1,j=len2;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                //just add it once and move back
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            }
            //upward movement
            else if(dp[i-1][j]>dp[i][j-1]){
                //if it does not match, then either you include the left or the up
                ans.append(s1.charAt(i-1));
                i--;
            }
            else{
                ans.append(s2.charAt(j-1));
                j--;
            }
        }
        while(i!=0){
            ans.append(s1.charAt(i-1));
            i--;
        }
        while(j!=0){
            ans.append(s2.charAt(j-1));
            j--;
        }
        return ans.reverse().toString();
    }
    private static String LCS(String s1, String s2){
        int len1= s1.length();
        int len2= s2.length();
        int[][] dp = new int[len1+1][len2+1];
        // 1 BASED INDEXING IN DP ARRAY, 0 BASED INDEXING IN STRING
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]= 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder ans= new StringBuilder();
        int i=len1,j=len2;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else{
                //move to the maximum of either left or above
                if(dp[i-1][j]>dp[i][j-1]){
                    //above is greater
                    i--;
                }
                else{
                    j--;
                }
            }
        }
        return ans.reverse().toString();
    }
    public static String shortestCommonSupersequence3Pointer(String s1, String s2) {
        String lcs = LCS(s1,s2);
        int len = lcs.length();
        int len1= s1.length();
        int len2= s2.length();
        int i=0,j=0,k=0;
        StringBuilder ans= new StringBuilder();
        while(k<len){
            while(s1.charAt(i)!=lcs.charAt(k)){
                ans.append(s1.charAt(i++));
            }
            while(s2.charAt(j)!=lcs.charAt(k)){
                ans.append(s2.charAt(j++));
            }
            //now is the time to append k
            ans.append(lcs.charAt(k++));
            i++;j++;
        }
        //now the remaining string
        while(i<len1){
            ans.append(s1.charAt(i++));
        }
        while(j<len2){
            ans.append(s2.charAt(j++));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s1= "dynamic",s2="program";
        System.out.println(shortestCommonSupersequence(s1,s2));
    }
}
