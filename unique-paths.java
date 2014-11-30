public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    // public int uniquePaths(int m, int n) {
    //     // write your code here 
    //     if (m == 0 || n == 0) {
    //     	return 0;
    //     }

    //     int[][] dp = new int[m][n];

    //     for (int i = 0; i < m; i++) {
    //     	dp[i][0] = 1;
    //     }
    //     for (int j = 0; j < n; j++) {
    //     	dp[0][j] = 1;
    //     }

    //     for (int i = 1; i < m; i++) {
    //     	for (int j = 1; j < n; j++) {
    //     		dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    //     	}
    //     }

    //     return dp[m - 1][n - 1];
    // }

    public int uniquePaths(int m, int n) {
        // write your code here 
        if (m == 0 || n == 0) {
        	return 0;
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
        	dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		dp[j] = dp[j - 1] + dp[j];
        	}
        }

        return dp[n -1 ];
    }
}

