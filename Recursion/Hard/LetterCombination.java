import java.util.*;

public class LetterCombination{
    public static List<String> letterCombinations(String digits) {
        HashMap<Character,String> map= new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        //now i just have to generate the subsets of this list
        List<String> ans= new ArrayList<>();
        generate(map,ans,new StringBuilder(),0,digits);
        return ans;
    }
    private static void generate(HashMap<Character,String> map, List<String> ans, StringBuilder sb, int index, String digits){
        if(index==digits.length()){
            ans.add(sb.toString());
            return;
        }
        //for the index i of digits, iterate the map and make recursive calls
        String t= map.get(digits.charAt(index));
        for(int i=0;i<t.length();i++){
            //you include t, and make recursive call
            sb.append(t.charAt(i));
            generate(map,ans,sb,index+1,digits);
            sb.deleteCharAt(sb.length()-1);
            
        }
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("34"));
    }
}