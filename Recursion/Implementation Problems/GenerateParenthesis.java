import java.util.*;

public class GenerateParenthesis{
    private static void generate(String s, List<String>ans, int open,int close, int n){
        if(open>n) return;
        if(open+close==2*n && open==close) {
            ans.add(s);
            return;
        }
        //recursive calls
        generate(s+'(', ans, open+1,close,n);
        if(open>close){
            generate(s+')',ans,open,close+1,n);
        }
    }
    public static List<String> generateParenthesis(int n){
        List<String> ans=new ArrayList<>();
        String s="";
        generate(s,ans,0,0,3);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}