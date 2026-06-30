package LIS;
import java.util.*;

public class LongestStringChain {
    private static boolean check(String a, String b){
        // a function to check whether the 2 strings differ by just one character
        int size1= a.length(), size2=b.length();
        //make it such that String a is always larger than String b
        if(Math.abs(size1-size2)!=1) return false;
        //use 2 pointer approach to see if the String differ by 1 character
        int i=0,j=0;
        //means that one move is pending
        boolean flag= true;
        while(i<size1 && j<size2){
            if(a.charAt(i)==b.charAt(j)) {
                i++;j++;
            }
            //if it is not equal, then just for once move it
            else if(flag){
                i++;
                flag=false;
            }
            else{
                return false;
            }

        }
        if(i==size1 && j==size2) return true;
        //if the move is still pending and i is still left 1 place to move
        if(j==size2 && i==size1-1 && flag){
            return true;
        }
        return false;
    }
    public static int longestStringChain(String[] words) {
        //same logic of longest increasing subsequence tabulation approach
        int len = words.length;
        if(len==0) return 0;
        if(len==1) return 1;
        Arrays.sort(words, (s1,s2)-> Integer.compare(s1.length(),s2.length()));
        int[] dp = new int[len];
        int maxCount=0;
        Arrays.fill(dp, 1);
        for(int ind=1;ind<len; ind++){
            for(int prev_ind = 0; prev_ind<ind; prev_ind++){
                if(check(words[ind], words[prev_ind])){
                    dp[ind]= Math.max(dp[prev_ind]+1, dp[ind]);

                }
            }
            maxCount= Math.max(maxCount, dp[ind]);
        }
        System.out.println(Arrays.toString(dp));
        return maxCount;
    }

    public static void main(String[] args) {
        String[] words={"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(longestStringChain(words));
    }
}
