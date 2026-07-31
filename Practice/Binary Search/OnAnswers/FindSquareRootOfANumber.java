package OnAnswers;

public class FindSquareRootOfANumber {
    public static int floorSqrt(int n) {
        // we can have low at 0 and high at n, so we know that 0 to n is sorted, so just apply binary search
        // and for the ones that dont have a definite answer, we have to return the floor i.e. the smaller than that integer
        // like for 28, square root is 5.something, so just return 5
        int low =0, high = n;
        int candidateAns = 1;
        while(low<=high) {
            int mid = low + (high - low)/2;
            long val = (long) mid * (long) mid;
            //base case
            if(val==(long)n) {
                return mid;
            }
            // otherwise check
            if(val<(long)n) {
                // this is a candidate answer
                // go right
                low = mid+1;
                candidateAns = Math.max(candidateAns, mid);
            }
            else{
                high = mid-1;
            }
        }
        return candidateAns;
    }

    static void main() {
        System.out.println(floorSqrt(28));
    }
}
