package Advanced_Algo;
import java.util.*;

public class RabinKarpAlgorithm {
    public List<Integer> search(String pat, String txt) {
        List<Integer> ans = new ArrayList<>();
        int p = 7, mod = 101;
        int hashPat = 0, hashText = 0;
        int pLeft= 1, pRight = 1;

        int n = txt.length(), m = pat.length();
        if(m>n) return ans;
        for(int i=0; i<m ;i++){
            hashPat += ((pat.charAt(i) - 'a' + 1 ) * pRight) % mod;
            hashText += ((txt.charAt(i) - 'a' + 1 ) * pRight) % mod;
            pRight = (pRight * p) % mod;
        }

        for(int i=0; i<=n-m ; i++){
            if(hashPat == hashText){
                // if the substring matches, then add it
                if(txt.substring(i, i+m).equals(pat)){
                    ans.add(i);
                }
            }
            // update the hash values
            if(i<n-m){
                hashText = (hashText - ((txt.charAt(i)-'a'+1)*pLeft)%mod + mod) % mod;
                hashText = (hashText + ((txt.charAt(i+m)-'a'+1)*pRight)%mod + mod) % mod;
                hashPat = (hashPat*p) % mod;
                pLeft = (pLeft*p) % mod;
                pRight = (pRight*p) % mod;
            }
        }
        return ans;
    }
}
