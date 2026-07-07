package Problems;

public class MinimumBitFlipsToConvertNumber {
    public int minBitsFlip(int start, int goal) {
        int ans = start^goal;
        return countBits(ans);
    }
    private int countBits(int n){
        int count=0;
        while(n!=0){
            n= n&(n-1);
            count++;
        }
        return count;
    }
}
