package Medium_Problems;
import java.util.*;
public class ReverseWordsInAString {
    public static StringBuilder reverseString(StringBuilder sb){
        int len = sb.length();
        for(int i=0;i<(len/2);i++){
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(len-1-i));
            sb.setCharAt(len-1-i, c);
        }
        return sb;
    }
    public static String reverseWords(String s){
        StringBuilder sb= new StringBuilder(s);
        sb= reverseString(sb);
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        // start from the end and pick the characters, at the end just reverse the string
        int i=0;
        while(i<n) {
            while(i<n && sb.charAt(i)==' ') i++;
            if(i>=n) break;
            StringBuilder word = new StringBuilder();
            while(i<n && sb.charAt(i)!=' ') {
                word.append(sb.charAt(i));
                i++;
            }
            word = reverseString(word);
            ans.append(word);
            if(i!=n){
                ans.append(' ');
            }
        }
        int size = ans.length()-1;
        int j =size;
        while(j>=0 && ans.charAt(j)==' '){
            ans.deleteCharAt(j);
            j--;
        }
        return ans.toString();
    }
    public static String reverseWordsBrute(String s) {
        s=s.trim();
        String[] split = s.split(" +");
        int len = split.length;
        for(int i=0; i<(len/2); i++){
            String t = split[i];
            split[i]= split[len-1-i];
            split[len-1-i]= t;
        }
        System.out.println(Arrays.toString(split));
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<len;i++){
            if(i==len-1){
                ans.append(split[i]);
            }
            else{
                ans.append(split[i]).append(" ");
            }
        }
        return ans.toString();
    }

    static void main() {
        String s= "  hello world  ";
        System.out.println((reverseWords(s)));
    }
}
