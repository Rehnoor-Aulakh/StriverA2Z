package Partition_DP;

import java.util.Arrays;

public class PalindromePartitioningII {
    private boolean isPalindrome(String s, int i, int j){
        //using 2 pointer approach, we need to check if the string s is palindrome or not
        if(i==j) return true;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
    private int f(String s, int i, int n, int[] dp){
        // IF END OF STRING IS REACHED, THEN NO MORE CUTS ARE NEEDED
        if(i==n) return 0;
        int mini =(int)1e9;
        if(dp[i]!=-1) return dp[i];
        for(int j=i; j<n;j++){
            // s[i..j] is a palindrome
            if(isPalindrome(s, i, j)){
                mini = Math.min(mini , 1+f(s, j+1, n, dp));
            }
        }
        return dp[i]= mini;
    }
    public int minCut (String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        Arrays.fill(dp, -1);
        return f(s, 0, len, dp) -1 ;
    }

    public static void main(String[] args) {
        PalindromePartitioningII obj = new PalindromePartitioningII();
        System.out.println( obj.minCut("madan") );
    }
}
