package Hard_Problems;
import java.util.*;

public class WordLadderII {
    /// Remember: This does not submit on leetcode, gives TLE because of complex test cases, but it is perfectly fine for interviews
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //first make set
        Set<String> set= new HashSet<>();
        for(String word: wordList) {
            set.add(word);
        }
        List<List<String>> ans= new ArrayList<>();
        if(!set.contains(endWord)) return ans;
        set.remove(beginWord);
        Queue<List<String>> queue= new LinkedList<>();
        List<String> first= new ArrayList<>();
        first.add(beginWord);
        queue.add(first);
        int level=1;
        Set<String> usedOnLevel= new HashSet<>();
        while(!queue.isEmpty()){
            List<String> top= queue.poll();
            //new level
            if(top.size()>level){
                level= top.size();
                for(String word: usedOnLevel){
                    set.remove(word);
                }
                usedOnLevel.clear();
            }
            //change the word, and append it on to the list
            String lastWord= top.get(top.size()-1);
            if(lastWord.equals(endWord)){
                ans.add(top);
                continue;
            }
            char[] arr= lastWord.toCharArray();
            for(int i=0;i<lastWord.length();i++){
                char original= arr[i];
                for(char ch='a';ch<='z';ch++){
                    arr[i]=ch;
                    String replacedWord= new String(arr);
                    if(set.contains(replacedWord)){
                        List<String> newPath= new ArrayList<>(top);
                        newPath.add(replacedWord);
                        queue.add(newPath);
                        usedOnLevel.add(replacedWord);
                    }
                }
                arr[i]=original;
            }
        }
        return ans;
    }
}
