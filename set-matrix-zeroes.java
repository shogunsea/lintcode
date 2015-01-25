public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        // O(1) space.
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int col = matrix[0].length;
        
        int rowIndex = 0;
        int colIndex = 0;
        boolean stop = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowIndex = i;
                    colIndex = j;
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            }
        }
        
        if (!stop) {
            return;
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == rowIndex || j == colIndex) {
                    continue;
                }
                
                if (matrix[i][j] == 0) {
                    matrix[rowIndex][j] = 0;
                    matrix[i][colIndex] = 0;
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == rowIndex || j == colIndex) {
                    continue;
                }
                if (matrix[rowIndex][j] == 0 || matrix[i][colIndex] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            matrix[i][colIndex] = 0;
        }
        for (int j = 0; j < col; j++) {
            matrix[rowIndex][j] = 0;
        }
        
    }
}


public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        // O(m + n) space.
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int col = matrix[0].length;
        
        boolean[] rowZeros = new boolean[row];
        boolean[] colZeros = new boolean[col];
        
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
               if (matrix[i][j] == 0) {
                    rowZeros[i] = true;
                    colZeros[j] = true;
                } 
                
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowZeros[i] || colZeros[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}
