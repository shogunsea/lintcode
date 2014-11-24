public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int sLen = S.length();
        int tLen = T.length();
        int[][] dp = new int[tLen][sLen];
        dp[0][0] = S.charAt(0) == T.charAt(0)? 1 : 0;
        // initialize first row
        for (int j = 1; j < sLen; j++) {
            if (S.charAt(j) == T.charAt(0)) {
                dp[0][j] = dp[0][j - 1] + 1;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        for (int i = 1; i < tLen; i++) {
            for (int j = i; j < sLen; j++) {
                if (S.charAt(j) == T.charAt(i) ) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        return dp[tLen - 1][sLen - 1];
    }
}
