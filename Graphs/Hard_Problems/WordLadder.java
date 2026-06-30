package Hard_Problems;
import java.util.*;

public class WordLadder {
    static class Pair{
        String word;
        int distance;
        Pair(String word, int distance){
            this.word= word;
            this.distance=distance;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //simple bfs traversal
        Set<String> set= new HashSet<String>();
        for(String word: wordList){
            set.add(word);
        }
        set.remove(beginWord);
        Queue<Pair> queue= new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        while(!queue.isEmpty()){
            //pick up a word from the queue and change the positions
            Pair top = queue.poll();
            String word= top.word;
            int distance=top.distance;
            //change the alphabets
            if(word.equals(endWord)) return distance;
            for(int i=0;i<word.length();i++){
                for(char ch='a'; ch<='z';ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord= new String(replacedCharArray);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        queue.add(new Pair(replacedWord, distance+1));
                    }
                }
            }
        }
        return 0;
    }
}
