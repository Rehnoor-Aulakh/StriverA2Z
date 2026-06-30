package DP_on_Strings;

public class DeleteOperationFor2Strings {
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
    public static int minDistance(String word1, String word2) {
        int LCS= lcs(word1, word2);
        return (word1.length()-LCS)+(word2.length()-LCS);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("etco","leetcode"));
    }

}
