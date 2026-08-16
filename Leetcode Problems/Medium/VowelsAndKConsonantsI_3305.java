package Medium;

import java.util.HashMap;

public class VowelsAndKConsonantsI_3305 {
    public int countOfSubstrings(String word, int k) {
        HashMap<Character, Integer> vowelMap = new HashMap<>();
        int left = 0, right = 0, count = 0;
        return 0;
    }

    private static boolean isVowel(char ch) {
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
    private static boolean isConsonant(char ch) {
        return ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u';
    }

}
