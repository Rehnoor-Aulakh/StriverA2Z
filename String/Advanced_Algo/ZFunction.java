package Advanced_Algo;

import java.util.*;

public class ZFunction {
    public static int[] zfunctionBrute(String s){
        int n = s.length();
        int[] z = new int[n];
        for(int i=1;i<n;i++){
            while(i+z[i]<n && s.charAt(i+z[i])== s.charAt(z[i])) z[i]++;
        }
        return z;
    }
    private static int[] computeZarray(String s){
        int n = s.length();
        int[] z = new int[n];
        int left =0, right = 0;
        for(int i=1;i<n;i++){
            // out of window
            if(i>right){
                while(i+z[i]<n && s.charAt(i+z[i])== s.charAt(z[i])){
                    z[i]++;
                }
            }
            //out of window
            else{
                if(i + z[i-left] <= right){
                    z[i] = z[i-left];
                }
                // compute again using brute force
                else{
                    z[i] = right - i + 1;
                    while(i+z[i]<n && s.charAt(i+z[i])==s.charAt(z[i])){
                        z[i]++;
                    }
                }
            }
            if(i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }
        return z;
    }
    public static List<Integer> search(String text, String pattern) {
        String s = pattern + '$' + text; // Combined string

        // Function call to find the Z array for the combined string
        int[] Z = computeZarray(s);

        // Length of pattern and text
        int n = text.length(), m = pattern.length();

        // To store the result
        List<Integer> ans = new ArrayList<>();

        // Iterate on the combined string after the delimiter
        for(int i = m+1; i < s.length(); i++) {
            if(Z[i] == m) {
                ans.add(i - (m + 1));
            }
        }

        return ans;
    }
    static void main() {
        System.out.println((search("abacaba","aba")));
    }
}

