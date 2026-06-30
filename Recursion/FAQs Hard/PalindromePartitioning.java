import java.util.*;

public class PalindromePartitioning{
    public static List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        List<String> t= new ArrayList<>();
        generate(ans, t, 0, s);
        return ans;
    }
    private static void generate(List<List<String>> ans, List<String> t, int index, String s){
        if(index==s.length()){
            ans.add(new ArrayList<>(t));
        }
        //generate combinations
        for(int i=index;i<s.length();i++){
            if(checkPalindrome(index, i, s)){
                //if index to i is palindrome
                //store it in t
                t.add(s.substring(index, i+1));
                //recursive call
                generate(ans,t,i+1,s);
                //backtrack
                t.remove(t.size()-1);
            }
        }
    }
    private static boolean checkPalindrome(int left, int right, String s){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s="aaba";
        System.out.println(partition(s));
    }
}