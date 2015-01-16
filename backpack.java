public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */

    // Brute force: O(n!) time.
    public int backPack(int m, int[] A) {
        // write your code here
        int len = A.length;
        if (len == 0) {
            return 0;
        }

        Arrays.sort(A);
        int[] max = {0};
        int[] curSum = {0};

        for (int i = 0; i < len; i++) {
            curSum[0] += A[i];
            helper(max, curSum, m, A, i);
            curSum[0] -= A[i];
        }

        return max[0];
    }
    
    public void helper(int[] max, int[] curSum, int m, int[] A, int preIndex) {
        if (curSum[0] > m) {
            int temp = curSum[0] - A[preIndex];
            max[0] = Math.max(max[0], temp);
            return;
        } else if (preIndex == A.length - 1) {
            max[0] = Math.max(max[0], curSum[0]);
            return;
        }

        for (int i = preIndex + 1; i < A.length; i++) {
            curSum[0] += A[i];
            helper(max, curSum, m, A, i);
            curSum[0] -= A[i];
        }
    }


    public int backPack(int m, int[] A) {
        // write your code here
        // the idea: use 2D dp
        // pick[i][j]: at index i we can achieve volume j.
        // result: pick[lastIndex][largestVolumeAchieveble], checking last row
        // from right bottom corner.
        // logic: if we can achieve volume j at index i, 
        //    we can also achieve it at index i + 1. so first simply copy
        //    value from previous row. Then check that if current target
        //    volume j can be achieved: by checking pick[i - 1][j - A[i - 1]]
        //    which means: if we pick current index at i, then previous i - 1
        //     index should be able to achieve j - A[i -1].
        int row = A.length + 1;
        int col = m + 1;
        boolean[][] pick = new boolean[row][col];
        pick[0][0] = true;
        
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // if we can achieve volume j at index i, 
                // we can also achieve it at index i + 1.
                pick[i][j] = pick[i - 1][j];
                // if we pick element at index i, previous i -1 index should
                // be able to achieve j - A[i - 1]
                if (j >= A[i - 1] && pick[i - 1][j - A[i - 1]]) {
                    pick[i][j] = true;
                }
            }
        }
        
        for (int j = col - 1; j >= 0; j--) {
            if (pick[row - 1][j]) {
                return j;
            }
        }
        
        return 0;
    }

}
