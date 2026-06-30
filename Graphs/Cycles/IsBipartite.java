package Cycles;
import java.util.*;



public class IsBipartite {

    public static long[] computeCounters(int[] arr) {
        int n = arr.length;
        long[] result = new long[n];

        // Keep track of the sum of elements to the left of the current index
        long prefixSum = 0;

        for (int i = 0; i < n; i++) {
            // Formula: (i * arr[i]) - (sum of all previous elements)
            // Cast 'i' to long before multiplication to prevent overflow
            result[i] = ((long) i * arr[i]) - prefixSum;

            // Add current element to the prefix sum for the next iterations
            prefixSum += arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(computeCounters(new int[]{2, 4, 3})));
    }
}