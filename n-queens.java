class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        int[] pos = new int[n];
        
        for (int i = 0; i < n; i++) {
            // fill each col for first row
            pos[0] = i;
            helper(res, pos, 1);
            // pos[0] = -1;
        }
        
        return res;
    }
    
    public void helper(ArrayList<ArrayList<String>> res, int[] pos, int row) {
        if (row == pos.length) {
            // valid match.
            buildRes(res, pos);
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
    
    public void buildRes(ArrayList<ArrayList<String>> res, int[] pos) {
        ArrayList<String> tempList = new ArrayList<String>();
        StringBuilder sb;
        for (int i = 0; i < pos.length; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < pos.length; j++) {
                if (pos[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            tempList.add(sb.toString());
        }
        res.add(tempList);
    }
};
