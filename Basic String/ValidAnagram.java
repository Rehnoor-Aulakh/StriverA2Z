public class ValidAnagram{
    public static boolean anagramString(String s, String t){
        //we need to return true if s and t are anagrams
        //approach 1: sort both s and t
        //if they come out to be same, then return true
        //easy but more time consuming for bigger strings
        //can be done in more easy way by creating a map
        //create just one map, and iterate first s and keep on incrementing
        //then iterate t, and decrement the frequency
        // at the end, if all frequencies are 0, then it is an anagram
        if(s.length()!=t.length()) return false;
        int[] arr= new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        for(int a: arr){
            if(a!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}