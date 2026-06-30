package Medium_Problems;

import java.util.Stack;

public class MinimumSwapsToMakeStringBalanced {
    public int minSwapsTemp(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        int i=0, j= n-1;
        int count=0;
        while(i<j){
            // check if i and j dont match
            if(sb.charAt(i)==']' && sb.charAt(j)=='['){
                //then swap i and j
                sb.setCharAt(i, '[');
                sb.setCharAt(j, ']');
                i++; j--;
                count++;
            }
            else if(sb.charAt(i)==']' && sb.charAt(j)==']'){
                j--;
            }
            else if(sb.charAt(i)=='[' && sb.charAt(j)=='['){
                i++;
            }
            else{
                i++;j--;
            }
        }
        return count;
    }

    public int minSwapsStack(String s) {
        Stack<Character> st = new Stack<>();
        int count =0;
        for(char ch: s.toCharArray()){
            if(ch=='['){
                //push onto the stack
                st.push(ch);
            }
            else if(ch==']' && (st.isEmpty() || st.peek()==']')){
                st.push(ch);
                count++;
            }
            else if(ch==']' && st.peek()=='['){
                st.pop();
            }
        }
        return (count+1)/2;
    }
    public int minSwaps(String s) {
        int size=0;
        for(char ch: s.toCharArray()){
            if(ch=='[') size++;
            else if(ch==']'){
                if(size>0){
                    size--;
                }
            }
        }
        return (size+1)/2;
    }

    static void main() {
        MinimumSwapsToMakeStringBalanced obj = new MinimumSwapsToMakeStringBalanced();
        System.out.println( obj.minSwaps("]]][[["));
    }
}
