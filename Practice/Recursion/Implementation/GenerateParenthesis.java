package Implementation;
import java.util.*;

public class GenerateParenthesis {
    private static void f(List<String> ans, int open , int close, StringBuilder s, int n) {
        // base case
        if(open==n && close ==n) {
            System.out.println(s);
            ans.add(s.toString());
        }
        // not possible case
        else if(open>n || close>n || close>open) return;
        // generate all combinations
        // you can either open this or close this
        s.append('(');
        f(ans, open+1, close, s, n);
        s.deleteCharAt(s.length()-1);
        s.append(')');
        f(ans, open, close+1, s, n);
        s.deleteCharAt(s.length()-1);

    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder s=  new StringBuilder("(");
        f(ans, 1, 0, s, n);
        return ans;
    }
    public static void main() {
        generateParenthesis(3);
    }
}
