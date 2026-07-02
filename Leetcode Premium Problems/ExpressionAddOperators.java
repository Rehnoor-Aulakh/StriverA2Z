import java.util.*;

class Solution2 {
    public List<String> addOperators(String s, int target) {
        List<String> result = new ArrayList<>();

        if(s.length()==0) return result;

        //Expression Builder
        StringBuilder expr = new StringBuilder();

        // start backtracking
        backtrack(s, target, 0, expr, result);
        return result;
    }
    // backtracking function that builds all possible expressions
    private void backtrack(String num, long target, int pos, StringBuilder expr, List<String> result){
        int n = num.length();
        if(pos==n){
            if(evaluate(expr.toString())==target){
                result.add(expr.toString());
            }
            return;
        }
        // try forming numbers from pos
        for(int end = pos; end<n; end++){
            // skip numbers with leading zero
            // means we dont include them
            if(end>pos && num.charAt(pos)=='0') break;

            String part = num.substring(pos, end+1);
            int exprLen = expr.length();
            if(pos==0){
                expr.append(part);
                backtrack(num, target, end+1, expr, result);
                // --- ADD THIS LINE TO FIX THE BUG ---
                expr.setLength(exprLen);
            }else{
                //try +
                expr.append('+').append(part);
                backtrack(num, target, end+1, expr, result);
                // after this, break off the + sign and the part
                expr.setLength(exprLen);
                expr.append('-').append(part);
                backtrack(num, target, end+1, expr, result);
                expr.setLength(exprLen);
                expr.append('*').append(part);
                backtrack(num, target, end+1, expr, result);
                expr.setLength(exprLen);

            }
        }
    }
    private long evaluate(String e) {
        long total = 0;
        long lastTerm = 0;
        long currentNumber = 0;

        char lastOp = '+';

        int n = e.length();
        for (int i = 0; i <= n; i++) {
            char c = (i < n ? e.charAt(i) : '#');

            if (i < n && Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            } else {
                if (lastOp == '+') {
                    total += lastTerm;
                    lastTerm = currentNumber;
                } else if (lastOp == '-') {
                    total += lastTerm;
                    lastTerm = -currentNumber;
                } else if (lastOp == '*') {
                    lastTerm = lastTerm * currentNumber;
                }

                if (i < n) lastOp = c;
                currentNumber = 0;
            }
        }

        total += lastTerm;
        return total;
    }
}

public class ExpressionAddOperators {
}
