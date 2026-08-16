package Easy;

import java.util.HashMap;

public class CountVowelSubstrings_2062 {
    public static int countVowelSubstrings(String word) {
        // sliding window approach need to count those occurrences where the window has just 5 vowels in it
        // same problem in this question, we cannot count directly all occurrences where there are 5 vowels because I would have to choose whether to move forward or remove from left
        // so need to create a helper function that finds at most k vowels
        return atMostKVowels(word, 5) - atMostKVowels(word, 4);
    }
    private static int atMostKVowels(String word, int k) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0, count = 0;
        for(right = 0; right< word.length(); right++) {
            // include this element only if it is a vowel
            char ch = word.charAt(right);
            if(isVowel(ch)) {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

                while(freqMap.size()>k) {
                    char leftChar = word.charAt(left);
                    int freq = freqMap.get(leftChar);
                    if(freq-1==0) {
                        // just remove this from map
                        // but currently this is still valid
                        // now the next time it would be invalid
                        freqMap.remove(leftChar);
                    } else {
                        // this is still a valid subarray
                        freqMap.put(leftChar, freq-1);
                    }
                    left++;
                }
                count += right-left+1;
            } else {
                // need to clear the map because we are starting a new window here
                freqMap.clear();
                left = right + 1;
            }

        }
        return count;
    }
    private static boolean isVowel(char ch) {
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }

    static void main() {
        System.out.println(countVowelSubstrings("cuaieuouac"));
    }
}
