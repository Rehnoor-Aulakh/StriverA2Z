package FAQs_Medium;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        // traverse top row from left to right
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0, down = rows-1;
        int left = 0, right = cols-1;
        // need to solve one edge case now->
        // 1
        // 2
        // 3
        // 4
        // 5
        while(top<=down && left<=right){
            // traverse left to right first
            int currRunning  = left;
            while(currRunning<=right && left<=right && top<=down){
                // traverse from left to right
                ans.add(matrix[top][currRunning++]);
            }
            top++;
            currRunning = top;
            // traverse from top+1 to down, and the column is right
            while(currRunning<=down && left<=right && top<=down){
                ans.add(matrix[currRunning++][right]);
            }
            right--;
            // traverse from right-1 to left
            currRunning = right;
            while(currRunning>=left && left<=right && top<=down){
                ans.add(matrix[down][currRunning--]);
            }
            down--;
            currRunning = down;
            // traverse from down-1 to the new top
            while(currRunning>=top && left<=right && top<=down){
                ans.add(matrix[currRunning--][left]);
            }
            // after this you need to move left ahead and right back
            left++;
        }
        return ans;
    }
}
