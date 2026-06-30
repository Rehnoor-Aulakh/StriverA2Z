
import java.util.Arrays;

public class AssignCookies{
    public int findMaximumCookieStudents(int[] greed, int[] s) {
        int n=greed.length;
        int m= s.length;
        Arrays.sort(greed);
        Arrays.sort(s);
        int left=0,right=0;
        while(left<n && right<m){
            if(greed[left]<=s[right])
            {
                left++;
                right++;
            }
            else{
                right++;
            }
        }
        return left;
    }
    
    public static void main(String[] args) {
        
    }    
}