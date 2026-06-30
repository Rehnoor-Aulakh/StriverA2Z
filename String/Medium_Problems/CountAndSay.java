package Medium_Problems;

public class CountAndSay {
    // TOP DOWN
    private StringBuilder f(StringBuilder s, int i){
        if(i==1){
            return s.append(1);
        }
        // recursively call
        StringBuilder sb = f(s, i-1);
        // now build the answer
        int len = sb.length();
        int freq=1;
        s= new StringBuilder();
        int j;
        for(j = 0; j <len-1; j++){
            if(sb.charAt(j)==sb.charAt(j+1)){
                freq++;
                continue;
            }
            else{
                s.append(freq);
                s.append(sb.charAt(j));
                freq = 1;
            }
        }
            s.append(freq);
            s.append(sb.charAt(j));


        return s;
    }
    public String countAndSayRecursive(int n) {
        StringBuilder s= new StringBuilder();
        return f(s, n).toString();
    }
    // BOTTOM UP APPROACH
    public String countAndSay(int n){
        if(n==0) return "";
        if(n==1) return "1";
        StringBuilder prev= new StringBuilder();
        StringBuilder curr = new StringBuilder();
        prev.append(1);
        for(int i=2;i<=n;i++){
            int len = prev.length();
            int j;
            int freq=1;
            for(j = 0; j <len-1; j++){
                if(prev.charAt(j)==prev.charAt(j+1)){
                    freq++;
                    continue;
                }
                else{
                    curr.append(freq);
                    curr.append(prev.charAt(j));
                    freq = 1;
                }
            }
            curr.append(freq);
            curr.append(prev.charAt(j));
            prev= curr;
            curr= new StringBuilder();
        }
        return prev.toString();

    }

    static void main() {
        CountAndSay obj = new CountAndSay();
        System.out.println(obj.countAndSay(6));
    }
}
