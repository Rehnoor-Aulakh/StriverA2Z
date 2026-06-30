import java.util.*;
import java.util.Map.Entry;

public class SortCharactersByFrequency{
    public static List<Character> frequencySort(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        //now we need to sort based on the values, so we first need to convert it to ArrayList
        //let us first convert the map to ArrayList
        List<Map.Entry<Character,Integer>> list= new ArrayList<>(map.entrySet());
        //now do the sorting
        Collections.sort(list, new Comparator<Entry<Character, Integer>>(){
            @Override
            public int compare(Entry<Character,Integer> e1, Entry<Character,Integer> e2){
                if(e1.getValue()<e2.getValue()){
                    return 1;
                }
                else if((e1.getValue()==e2.getValue()) && (e2.getKey()<e1.getKey())){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });
        //this would sort by values in decreasing order, and if it is same
        // System.out.println(list);
        //now let us build the answer
        List<Character> ans= new ArrayList<>();
        for(var l: list){
            ans.add(l.getKey());
        }

        return ans;
    }
    public static void main(String[] args) {
        String s= "tree";
        System.out.println(frequencySort(s));
    }
}