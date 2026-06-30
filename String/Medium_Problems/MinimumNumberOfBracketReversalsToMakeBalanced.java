package Medium_Problems;

import java.util.Arrays;
import java.util.Stack;

public class MinimumNumberOfBracketReversalsToMakeBalanced {
    int len;
    int maxOpen;
    //function to check isBalanced
    private boolean isBalanced(StringBuilder s){
        Stack<Character> st = new Stack<>();
        for(char ch: s.toString().toCharArray()){
            if(ch=='('){
                st.push(')');
            }
            else if(ch==')' && st.isEmpty()){
                return false;
            }
            else{
                st.pop();
            }
        }
        return st.isEmpty();
    }
    private int f(String s, int i, int open, int[][] dp){
        if(i==len){
            return open == 0 ? 0: (int)1e9;
        }
        // if there are more closing brackets ( than opening ones, then it is impossible
        if(open <0 || open>maxOpen) return (int)(1e9);
        if(dp[i][open]!=-1) return dp[i][open];
        // do reverse and dontReverse
        int mini = (int)1e9;
        if(s.charAt(i)=='('){
            int keep = f(s, i+1, open+1, dp);
            // reverse ( with ), so open counter goes down
            int reverse = 1 + f(s, i+1, open-1, dp);
            mini = Math.min(keep, reverse);
        }
        else{
            int keep = f(s, i+1, open-1, dp);
            int reverse = 1 + f(s, i+1, open+1, dp);
            mini= Math.min(keep, reverse);
        }
        return dp[i][open] = mini;
    }
    public int countRevMemoization(String s) {
        this.len = s.length();
        this.maxOpen = len/2;
        int[][] dp = new int[len][maxOpen+1];
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i], -1);
        }
        if(len%2!=0) return -1;
        return f(s, 0,0,dp);
    }
    // since there is a stack overflow error, so lets do tabulation now
    public int countRevTabulation(String s){
        int len = s.length();
        if(len%2!=0) return -1;
        int maxOpen = len/2;
        int[][] dp = new int[len+1][maxOpen+1];
        //for the last row, just the first column would be 0, rest all INT_MAX
        for(int open = 1; open<=maxOpen; open++){
            dp[len][open] = (int)1e9;
        }
        for(int i=len-1 ; i>=0; i--){
            for(int open = 0; open<=maxOpen ; open++){
                int mini = (int)1e9;
                if(s.charAt(i)=='('){
                    int keep = (open+1<=maxOpen) ? dp[i+1][open+1] : (int)1e9;
                    // reverse ( with ), so open counter goes down
                    int reverse = (open-1>=0) ? 1 + dp[i+1][open-1] : (int)1e9;
                    mini = Math.min(keep, reverse);
                }
                else{
                    int keep =  (open-1>=0) ?  dp[i+1][open-1] : (int)1e9;
                    int reverse = (open+1<=maxOpen) ?  1 + dp[i+1][open+1] : (int)1e9;
                    mini= Math.min(keep, reverse);
                }
                dp[i][open] = mini;
            }
        }
        return dp[0][0];
    }
    public int countRev(String s){
        int len = s.length();
        if(len%2!=0) return -1;
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='('){
                //just push it onto the stack
                st.push(ch);
            }
            else if(ch==')' && (st.isEmpty() || st.peek()==')')){
                st.push(ch);
            }
            else if(ch==')' && st.peek()=='('){
                //remove it
                st.pop();
            }
        }
        //after this you will be left only with the unbalanced part
        int n= st.size();
        int open = 0;
        // check the open brackets in the stack
        while(!st.isEmpty() && st.peek()!=')'){
            open++;
            st.pop();
        }
        int close = n-open;
        if(close%2==0 && open%2==0){
            //if both are even, then they will for pairs with themselves
            return (n/2);
        }
        else{
            return (n/2-1)+2;
        }
    }
    static void main() {
        MinimumNumberOfBracketReversalsToMakeBalanced obj = new MinimumNumberOfBracketReversalsToMakeBalanced();
        System.out.println(obj.countRev(")(())((("));
    }
}
