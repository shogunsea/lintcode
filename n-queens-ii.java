class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        //write your code here
        int[] pos = new int[n];
        int[] res = new int[1];
        for (int i = 0; i < n; i++) {
            // fill each col for first row
            pos[0] = i;
            helper(res, pos, 1);
            // pos[0] = -1;
        }
        return res[0];
    }
    
    public void helper(int[] res, int[] pos, int row) {
        if (row == pos.length) {
            // valid match.
            res[0] += 1;
            return;
        }
        
        // try current row
        for (int i = 0; i < pos.length; i++) {
            // 
            if (isValid(pos, row, i)) {
                int temp = pos[row];
                pos[row] = i;
                helper(res, pos, row + 1);
                pos[row] = temp;
            }
        }
    }
    
    public boolean isValid(int[] pos, int row, int col) {
        for (int i = 0; i < row; i++) {
            int qRow = i;
            int qCol = pos[i];
            int tryRow = row;
            int tryCol = col;
            
            // check col
            if (qCol == tryCol) {
                return false;
            }
            // check diag
            if (Math.abs(tryCol - qCol) == Math.abs(tryRow - qRow)) {
                return false;
            }
        }
        return true;
    }
};


