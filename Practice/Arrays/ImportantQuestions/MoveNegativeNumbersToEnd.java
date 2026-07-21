package ImportantQuestions;

import java.util.*;

public class MoveNegativeNumbersToEnd {
    private void reverse(int[] arr, int low, int high){
        while(low < high){
            int t = arr[low];
            arr[low] = arr[high];
            arr[high] = t;
            low++;
            high--;
        }
    }

    private int split(int[] arr, int low, int high){
        if(low == high){
            return (arr[low] < 0) ? low : -1;
        }

        int mid = (low + high) / 2;
        int leftNegBegin = split(arr, low, mid);
        int rightNegBegin = split(arr, mid + 1, high);

        // MERGE CASE 1: Left half contains all positives.
        // Right side's structure is already correct relative to the left.
        if(leftNegBegin == -1){
            return rightNegBegin;
        }

        // Determine the exact ending index of the positive block on the right side.
        int rightPosEnd = (rightNegBegin == -1) ? high : rightNegBegin - 1;

        // Perform the 3 block reversal technique using the corrected boundary
        reverse(arr, leftNegBegin, mid);
        reverse(arr, mid + 1, rightPosEnd);
        reverse(arr, leftNegBegin, rightPosEnd);
        // -1 2 -7 4 -3 8 -5 6
        // 2 4 -1  -7 || 8 6 -3 -5
        // 2 4 -7 -1 || 6 8 -3 -5
        //  2 4 8 6 -1 -7 -3 -5

        // Calculate the new absolute starting index of the merged negative block
        int totalRightPositives = rightPosEnd - (mid + 1) + 1;
        return leftNegBegin + totalRightPositives;
    }

    public void segregateElements(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        split(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 4, -5, 6};
        MoveNegativeNumbersToEnd obj = new MoveNegativeNumbersToEnd();
        obj.segregateElements(arr);

        // Prints beautifully: [2, 4, 6, -1, -3, -5]
        System.out.println(Arrays.toString(arr));
    }
}