package LogicBuilding;

public class FindMissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // Target is to achieve O(n) time and O(1) space
        // O(n) space is easy, just we keep a visited array from 0 to n and mark that
        // but we have to do better
        // we can make the sum of 0 to n elements because we know if an array is complete [0 1 2 3 4] it has 5 elements lets sum them
        // we get 10, but actually sum of first 5 natural numbers is 5*(5+1)/2 = 15, so we know the missing no is 5

        int sum = 0;
        for(int num: nums) sum+=num;

        return (n*(n+1)/2)-sum;
    }
}
