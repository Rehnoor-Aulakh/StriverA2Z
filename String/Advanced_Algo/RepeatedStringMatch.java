package Advanced_Algo;

public class RepeatedStringMatch {
    public int rabinKarp(String txt, String pat) {
        int ans = -1;
        int p = 7, mod = 101;
        int hashPat = 0, hashText = 0;
        int pLeft= 1, pRight = 1;

        int n = txt.length(), m = pat.length();
        if(m>n) return -1;
        for(int i=0; i<m ;i++){
            hashPat += ((pat.charAt(i) - 'a' + 1 ) * pRight) % mod;
            hashText += ((txt.charAt(i) - 'a' + 1 ) * pRight) % mod;
            pRight = (pRight * p) % mod;
        }

        for(int i=0; i<=n-m ; i++){
            if(hashPat == hashText){
                // if the substring matches, then add it
                if(txt.substring(i, i+m).equals(pat)){
                    ans= i;
                    return ans;
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
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b)) return 1;
        int count=1;
        StringBuilder source = new StringBuilder(a);
        while(source.length()<b.length()){
            source.append(a);
            count++;
        }
        if(rabinKarp(source.toString(), b)!=-1) return count;

        source.append(a);
        count++;
        if(rabinKarp(source.toString(), b)!=-1) return count;

        return -1;
    }

    static void main() {
        RepeatedStringMatch obj = new RepeatedStringMatch();
        System.out.println(obj.repeatedStringMatch("a", "aa"));
    }
}
