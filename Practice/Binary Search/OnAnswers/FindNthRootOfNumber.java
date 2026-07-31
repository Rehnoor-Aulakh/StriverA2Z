package OnAnswers;

public class FindNthRootOfNumber {
    public int NthRoot(int N, int M) {
        int low = 0, high = M;
        while(low<=high) {
            int mid = low + (high-low)/2;
            long val = (long) Math.pow(mid, N);
            if(val == (long)M) {
                return mid;
            }
            else if(val<(long)M) {
                // go right
                low = mid+1;
            }
            else{
                high= mid-1;
            }

        }
        return -1;
    }
}
