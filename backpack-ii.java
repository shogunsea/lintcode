public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int len = A.length;
        if (len == 0) {
            return 0;
        }

        int[][] dp = new int[len + 1][m + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= m; j++) {
                if (A[i - 1] <= j) {
                    int include = V[i - 1] + dp[i - 1][j - A[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len][m];
    }


    // Recursion: TLE
    // public static int backPackII2(int m, int[] A, int V[]) {
    //     // write your code here
    //     return helper(m, A, V, A.length - 1);
    // }

    // public static int helper(int m, int[] A, int[] V, int n) {
    //     if (n < 0 || m == 0) {
    //         return 0;
    //     }

    //     if (A[n] > m) {
    //         return helper(m, A, V, n - 1);
    //     } else {
    //         int include = helper(m - A[n], A, V, n - 1) + V[n];
    //         int exclude = helper(m, A, V, n - 1);
    //         return Math.max(include, exclude);
    //     }
    // }
}
