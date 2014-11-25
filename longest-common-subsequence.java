public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int aLen = A.length();
        int bLen = B.length();
        int[][] dp = new int[aLen + 1][bLen + 1];
        
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                char a = A.charAt(i - 1);
                char b = B.charAt(j - 1);
                int aTob = dp[i][j - 1];
                int bToa = dp[i - 1][j];
                int diag = dp[i - 1][j - 1];
                if (a == b) {
                    // dp[i][j] = aTob < bToa? Math.max(bToa + 1, diag + 1) : Math.max(aTob + 1, diag + 1);
                    dp[i][j] = diag + 1;
                } else {
                    // dp[i][j] = aTob < bToa? Math.max(bToa, diag) : Math.max(aTob, diag);
                    dp[i][j] = aTob < bToa? bToa : aTob;
                }
            }
        }
        
        return dp[aLen][bLen];
    }
}

