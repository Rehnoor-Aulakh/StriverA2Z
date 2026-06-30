import java.util.*;

public class MinimumWindowSubstring{
    public static String minWindow(String s, String t) {
        int[] map = new int[128];
        for(char c: t.toCharArray()){
            map[c]++;
        }
        // int startIndex=-1;
        int count=0;
        int l=0,r=0;
        int t_length=t.length();
        String ans="";
        int minLength=Integer.MAX_VALUE;
        for(r=0;r<s.length();r++){
            //include this element
            if(map[s.charAt(r)]>0) count++;
            map[s.charAt(r)]--;
            while(count==t_length){
                //this is valid, so update
                if(minLength>r-l+1){
                    minLength=r-l+1;
                    ans=s.substring(l,r+1);
                }
                //shrink the window
                map[s.charAt(l)]++;
                if(map[s.charAt(l)]>0){
                    count--;
                }
                l++;
            }

        }
        return ans;

    }
    private static boolean isValid(HashMap<Character,Integer> t_map,HashMap<Character,Integer> s_map) {
        //check if s_map contains all entries of t_map
        //so we need to iterate over t_map and for every character in t_map, we need to check if s_map contains more or equal values
        for(Map.Entry<Character,Integer> entry: t_map.entrySet()){
            char c= entry.getKey();
            int val= entry.getValue();
            if(s_map.containsKey(c)){
                if((s_map.get(c)>=val)){
                    continue;
                }
            }
            return false;
        }
        return true;
    }
    public static String minWindowBetter(String s, String t){
        HashMap<Character,Integer> t_map= new HashMap<>();
        HashMap<Character,Integer> s_map= new HashMap<>();
        for(char c: t.toCharArray()){
            t_map.put(c,t_map.getOrDefault(c, 0)+1);
        }
        int l=0,r=0;
        int n=s.length();
        int minLen= Integer.MAX_VALUE;
        String ans="";
        for(r=0;r<n;r++){
            s_map.put(s.charAt(r),s_map.getOrDefault(s.charAt(r),0)+1);
            while(l<n && isValid(t_map,s_map)){
                //shrink the window
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    ans=s.substring(l, r+1);
                }
                //remove the l from s_map
                //I know it contains l
                int val= s_map.get(s.charAt(l));
                val--;
                if(val==0){
                    s_map.remove(s.charAt(l));
                }
                else{
                    s_map.put(s.charAt(l), val);
                }
                l++;
            }
            //after the loop, it would be invalid
            if(l==n) return ans;
            //otherwise expand the window
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}