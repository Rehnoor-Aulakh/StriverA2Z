package OnAnswers;

public class FindSmallestDivisor {
    private int sumByD(int[] nums, int divisor) {
        int sum = 0;
        for(int num: nums) {
            sum+= (int) Math.ceil((double)num/(double)divisor);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int limit) {
        // first find the max number of the array
        int maxi = Integer.MIN_VALUE;
        // and calculate the sum
        for(int num: nums) {
            maxi = Math.max(maxi, num);
        }
        // the search range is 1..maxi
        int low = 1, high = maxi;
        int candidateAns = 0;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(sumByD(nums, mid) <=limit) {
                candidateAns = mid;
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return candidateAns;
    }
}
