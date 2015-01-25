public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        int row = board.length;
        if (row == 0) {
            return false;
        }
        int col = board[0].length;
        int len = word.length();
        if (row * col < len) {
            return false;
        }
        
        boolean[][] visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (doesExist(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean doesExist(char[][] board, boolean[][] visited, int x, int y, int index, String word) {
        if (x < 0 || x == board.length || y < 0 || y == board[0].length || visited[x][y]) {
            return false;
        }
        
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        
        if (index + 1 == word.length()) {
            return true;
        }
        
        visited[x][y] = true;
        
        if (doesExist(board, visited, x - 1, y, index + 1, word)) {
            return true;
        }
        if (doesExist(board, visited, x + 1, y, index + 1, word)) {
            return true;
        }
        if (doesExist(board, visited, x, y - 1, index + 1, word)) {
            return true;
        }
        if (doesExist(board, visited, x, y + 1, index + 1, word)) {
            return true;
        }
        
        visited[x][y] = false;
        
        return false;
    }
}
