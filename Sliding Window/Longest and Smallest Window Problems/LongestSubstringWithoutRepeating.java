
import java.util.Arrays;


public class LongestSubstringWithoutRepeating{
    public static int longestNonRepeatingSubstringSlidingWindows(String s) {
        int[] map=new int[256];
        Arrays.fill(map,-1);
        int n=s.length();
        int maxLen=0;
        int left=0,right=0;
        for(right=0;right<n;right++){
            //a character is considered not there only if it is not after left
            //which means it should be lesser than left to just move forw
            if(map[s.charAt(right)]<left){
                //it is not there
                map[s.charAt(right)]=right;
            }
            else{
                //it is there 
                left=map[s.charAt(right)]+1;
                map[s.charAt(right)]=right;
            }
            maxLen=Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }

    public static int longestNonRepeatingSubstring(String s) {
        int[] map;
        int n=s.length();
        int maxLen=0;
        //iterate the string and store it into map
        for(int i=0;i<n;i++){
            int len=0;
            map=new int[26];
            for(int j=i;j<n;j++){
                //include i till n to see if it is unique
                if(map[s.charAt(j)-'a']!=0){
                    //this index is already in map
                    break;
                }
                else{
                    //this index is not in map, include it and move forward
                    map[s.charAt(j)-'a']++;
                    len++;
                }
            }
            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(longestNonRepeatingSubstringSlidingWindows("abcddabac"));
    }
}