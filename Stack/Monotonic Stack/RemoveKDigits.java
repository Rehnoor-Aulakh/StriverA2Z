import java.util.*;
public class RemoveKDigits {
    public static String  removeKdigits(String num, int k) {
        int n=num.length();
        if(k==n) return "0";
        Stack<Integer> st= new Stack<>();
        for(char ch: num.toCharArray()){
            int element=ch-'0';
            while(!st.isEmpty() && k>0 && element<st.peek()){
                st.pop();
                k--;
            }
            st.push(element);
            //k is still left, pop from the end

            if(st.isEmpty()){
                return "0";
            }
        }
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        //make the string out of it
        StringBuilder ans= new StringBuilder();
        while(!st.isEmpty()){
            ans.insert(0,st.pop().toString());
        }
        //remove the leading zeros
        while(!ans.isEmpty() && ans.charAt(0)=='0'){
            ans.deleteCharAt(0);
        }
        return ans.isEmpty()?"0":ans.toString();

    }
    public static void main() {
        System.out.println(removeKdigits("10",1));
    }
}
