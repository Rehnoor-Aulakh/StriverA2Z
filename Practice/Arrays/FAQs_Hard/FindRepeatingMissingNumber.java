package FAQs_Hard;

public class FindRepeatingMissingNumber {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int sum = 0;
        // now find sum of squares
        int sumSquares = 0;
        for(int num: nums){
            sumSquares+=num*num;
            sum+=num;
        }
        int n = nums.length;
        int targetSum  = n*(n+1)/2;
        int targetSumSquare = (n*(n+1)*(2*n+1))/6;
        // X-Y
        int diff = targetSum-sum;
        int squaredDiff = targetSumSquare - sumSquares;
        // X^2 - Y^2
        // square missing number - square repeating number's
        // X^2 - Y^2 = (X-Y)*(X+Y)
        // X+Y = (X^2 - Y^2)/(X-Y)
        int xplusy = squaredDiff/diff;
        // X+Y-(X-Y) = 2y
        int y  = (xplusy - diff)/2;
        int x = (xplusy-y);
        return new int[]{y,x};


    }
}
