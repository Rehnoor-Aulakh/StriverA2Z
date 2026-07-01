import java.util.Arrays;

class FourKeysKeyboard {
    public int larrysSolution(int n){
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=i;
        }
        for(int i=6;i<=n;i++){
            // j is the number of ctrl-v's
            for(int j =1; j<= i-2; j++){
                if(i-2-j>=0){
                    dp[i] = Math.max(dp[i], dp[i-2-j]*(j+1));
                }
            }
        }
        return dp[n];
    }
    public int maxA(int n) {
        if(n<=5) return n;
        int[] dp = new int[n+10];
        dp[1]= 1;
        for(int i=1; i<=n;i++){
            // Press 'A'
            dp[i+1] = Math.max(dp[i+1], dp[i]+1);
            // use ctrl-a, ctrl-c, ctrl-v
            dp[i+3] = Math.max(dp[i+3], dp[i]*2);
            dp[i+4] = Math.max(dp[i+4], dp[i]*3);
            dp[i+5] = Math.max(dp[i+5], dp[i]*4);
        }
        return dp[n];
    }

    static void main() {
        FourKeysKeyboard obj = new FourKeysKeyboard();
        // AAAA then 1+1 = 6, left with 3 => 12
        // AAA then2 = 5 AAA*4 = 16 max = 16
        // AAAA then +2 = 6, you are left with 4 4*4 =16
        // or AAAAA + 2 = 7 *3 => 20
        System.out.println( obj.maxA(10));
    }
}


class FourKeysKeyboardMemoization {
    ///  A FUNCTION THAT TAKES N REMAINING, THE SCREEN COUNT AND THE BUFFER COUNT
    /// OUR TARGET IS TO MAXIMIZE THE SCREEN COUNT
    private int f(int n, int[] dp){
        if(n<=5) return n;
        // if already memoized result, return it as it is
        if(dp[n]!=-1) return dp[n];
        // Press 'A' operation
        int result = f(n-1, dp) + 1;
        // try all copy-paste combinations
        // i are the number of ctrl -v and 2 is for ctrl-a + ctrl-c
        for(int i=1; i<=4; i++){
            if(n-i-2 >= 1){
                int current = f(n-i-2, dp)*(i+1);
                result = Math.max(result, current);
            }
        }
        dp[n]= result;
        return result;
    }
    public int maxA(int n) {
        if(n<=5) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(n, dp);
    }

    static void main() {
        FourKeysKeyboard obj = new FourKeysKeyboard();
        // AAAA then 1+1 = 6, left with 3 => 12
        // AAA then2 = 5 AAA*4 = 16 max = 16
        // AAAA then +2 = 6, you are left with 4 4*4 =16
        // or AAAAA + 2 = 7 *3 => 20
        System.out.println( obj.maxA(10));
    }
}

class FourKeysKeyboardRecursion {
    ///  A FUNCTION THAT TAKES N REMAINING, THE SCREEN COUNT AND THE BUFFER COUNT
    /// OUR TARGET IS TO MAXIMIZE THE SCREEN COUNT
    private int f(int n, int sc, int bc){
        if(n<0) return 0;
        if(n==0) return sc;
        // there are 3 options
        // first option is just include A
        int first = f(n-1, sc+1, bc);
        // second option is to paste what is there in the buffer
        int second = 0;
        if(bc>0){
            second = f(n-1, sc+bc, bc);
        }
        // third option is to first ctrl-a and then ctrl-c, and do only if sc>0
        int third = 0;
        if(sc>0 && n>2){
            third = f(n-2, sc, bc+sc);
        }
        return Math.max(first, Math.max(second, third));
    }
    public int maxA(int n) {
        // this is a 3d dp problem because 3 variables are changing
        return f(n, 0, 0);
    }
}
