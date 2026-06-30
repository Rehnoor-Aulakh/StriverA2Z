import java.util.*;

public class AtMostKDistinctChar{
    public static int kDistinctCharBetter(String s,int k){
        int l=0,r=0;
        int maxLen=0;
        HashMap<Character,Integer> map= new HashMap<>();
        for(r=0;r<s.length();r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            //check if it is invalid
            while(map.size()>k){
                //remove the element from l
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            maxLen= Math.max(maxLen, r-l+1);
            
        }
        return maxLen;
    }
    public static int kDistinctCharOptimal(String s, int k) {
        //move the window entirely, no need to shrink it below maxLen
        HashMap<Character,Integer> map= new HashMap<>();
        int l=0,r=0;
        int maxLen=0;
        for(r=0;r<s.length();r++){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r), 0)+1);
            // add it to the map

            //after that check if it is valid
            //if it is invalid, shrink the window from the left
            if(map.size()>k){
                char charL= s.charAt(l);
                map.put(charL, map.get(charL)-1);
                if(map.get(charL)==0){
                    map.remove(charL);
                }
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(kDistinctCharOptimal("abcddefg", 3));
    }
}