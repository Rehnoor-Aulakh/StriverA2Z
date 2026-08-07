package FAQs;

public class MedianOf2SortedArrays {
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        // 1. Always binary search on the smaller array
        if (arr1.length > arr2.length) {
            return findMedianSortedArrays(arr2, arr1);
        }

        int n1 = arr1.length;
        int n2 = arr2.length;

        int low = 0, high = n1;
        // Total elements needed on the left side of the partition
        int leftHalfSize = (n1 + n2 + 1) / 2;

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = leftHalfSize - cut1;

            // 2. Use Sentinels for clean boundary checks
            int left1  = (cut1 == 0)  ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : arr1[cut1];

            int left2  = (cut2 == 0)  ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : arr2[cut2];

            // 3. Valid Partition Condition
            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 1) {
                    // Odd total size: max of left partition is the median
                    return Math.max(left1, left2);
                } else {
                    // Even total size: average of max-left and min-right
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
            }
            // 4. Adjust Binary Search Range
            else if (left1 > right2) {
                high = cut1 - 1; // Took too many elements from arr1
            } else {
                low = cut1 + 1;  // Took too few elements from arr1
            }
        }

        return 0.0;
    }

    static void main() {
        System.out.println(findMedianSortedArrays(new int[]{2, 4, 6}, new int[]{1,3}));
    }

}
