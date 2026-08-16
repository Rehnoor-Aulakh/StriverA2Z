package Arrays;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros_73 {
    public void setZeroes(int[][] matrix) {
        // we will use the first row and first column to mark which row or column should be set to zero, rendering us a space of O(1)
        int rows = matrix.length;
        int cols = matrix[0].length;
        int col0 = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(matrix[i][j]==0) {
                    // mark the first column as 0
                    matrix[i][0] = 0;
                    // mark the first row as 0
                    if(j!=0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                if(matrix[i][j] != 0) {
                    // then I need to check the first row and first column
                    // check for column
                    if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if(matrix[0][0] ==0) {
            // every one in first row will be zero
            for(int j=0; j<cols; j++) {
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0) {
            for(int i=0; i<rows; i++) {
                matrix[i][0] = 0;
            }
        }

    }
    public void setZeroesBrute(int[][] matrix) {
        // If I create a set of rows and columns to make zeros, it will save a lot of computation
        Set<Integer> rowZeros = new HashSet<>();
        Set<Integer> colZeros = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(matrix[i][j]==0) {
                    rowZeros.add(i);
                    colZeros.add(j);
                }
            }
        }
        for(int row: rowZeros) {
            //make this entire row zero
            for(int col = 0; col< cols; col++) {
                matrix[row][col] = 0;
            }
        }
        for(int col: colZeros) {
            for(int row = 0; row< rows; row++) {
                matrix[row][col] = 0;
            }
        }
    }
}
