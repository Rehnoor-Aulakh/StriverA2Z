import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BraceExpansion {
    private void dfs(int i, StringBuilder currentString, String s, List<String> ans){
        if(i==s.length()){
            ans.add(currentString.toString());
            return;
        }
        char ch = s.charAt(i);
        if(ch!='{'){
            //then it is a normal character
             currentString.append(ch);
             dfs(i+1, currentString, s, ans);
             currentString.deleteCharAt(currentString.length()-1);
             return;
        }
        // we encountered {
        int close = i;
        while(s.charAt(close)!='}') close++;
        // collect all options from inside the braces
        List<Character> options = new ArrayList<>();
        for(int index = i+1; index<close; index++){
            if(s.charAt(index)!=','){
                options.add(s.charAt(index));
            }
        }
        Collections.sort(options);
        // try every option
        for(char option: options){
            currentString.append(option);
            dfs(close +1, currentString, s, ans);
            currentString.deleteCharAt(currentString.length()-1);
        }
    }
    public String[] expand(String s) {
        List<String> ans = new ArrayList<>();
        dfs(0, new StringBuilder(), s, ans);
        return ans.toArray(new String[0]);

    }
    static void main() {
        BraceExpansion obj = new BraceExpansion();
        System.out.println(Arrays.toString(obj.expand("{a,b}c{d,e}f")));
    }
}
