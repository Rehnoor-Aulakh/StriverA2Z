import java.util.*;

public class ValidParenthesisChecker{
    public boolean isValid(String s) {
        int min=0, max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }
            else if(s.charAt(i)==')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(max<0) return false;
            if(min<0) min=0;
        }
        return min==0;
    }

    private Map<String,Boolean> memo;
    public boolean checkValidString(String s){
        //recursively, try replacing every asterick by first ( then ) then empty
        //this is a backtracking problem
        //i am gonna iterate it
        memo= new HashMap<>();
        return dfs(s,0,0);
    }
    private boolean dfs(String s, int index, int openCount){
        if(openCount<0) return false;
        if(index==s.length()) return openCount==0;

        //Memoization key
        String key = index+","+openCount;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        char c= s.charAt(index);
        boolean result;
        if(c=='('){
            result = dfs(s,index+1,openCount+1);
        }
        else if(c==')'){
            result = dfs(s,index+1, openCount-1);
        }
        else{
            //Asterick
            result=dfs(s,index+1,openCount+1) || dfs(s,index+1,openCount-1) || dfs(s,index+1,openCount);
        }
        memo.put(key,result);
        return result;

    }
    public boolean isValidStackApproach(String s) {
        Stack<Integer> bracketStack = new Stack<>();
        Stack<Integer> asterickStack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                bracketStack.add(i);
            }
            else if(c=='*'){
                asterickStack.add(i);
            }
            //there is a closing bracket now, try popping from asterickStack
           
            else if(!bracketStack.isEmpty()){
                bracketStack.pop();
            }
             else if(!asterickStack.isEmpty()){
                asterickStack.pop();
            }
            else{
                return false;
            }
        } 
        //at the end we need to check if the astericks were at the end
        //because if astericks were before the closing bracket, then they are already covered
        while(!asterickStack.isEmpty() && !bracketStack.isEmpty() && asterickStack.peek()>bracketStack.peek()){
            asterickStack.pop();
            bracketStack.pop();
        }
        //if anything is left
        if(!asterickStack.isEmpty() || !bracketStack.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}