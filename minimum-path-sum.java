public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < col; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        return grid[row - 1][col - 1];
    }
}

