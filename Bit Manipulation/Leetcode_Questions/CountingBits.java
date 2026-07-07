package Leetcode_Questions;

public class CountingBits {
    // dp + bit manipulation approach
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0]=0;
        if(n==0) return ans;
        ans[1]= 1;
        if(n==1) return ans;
        for(int i=2;i<=n;i++){
            // find the last bit, which would be either 0 or 1
            // we can do an and with 0000000001
            int lastBit = (i&1);
            ans[i]= ans[i/2]+lastBit;
        }
        return ans;
    }

    static void main() {
        System.out.println(2&1);
    }
}
