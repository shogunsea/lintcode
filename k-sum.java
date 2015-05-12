public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public int kSum(int A[], int k, int target) {
        // write your code here
        int[][] dp = new int[k + 1][target + 1];
        dp[0][0] = 1;
        for (int j = 0; j < A.length; j++) {
            for (int p = target; p >= A[j]; p--) {
                for (int i = 1; i <= k; i++) {
                    dp[i][p] += dp[i - 1][p - A[j]];
                }
            }
        }
        return dp[k][target];
    }
}

