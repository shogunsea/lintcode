public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int aLen = A.length();
        int bLen = B.length();
        if (aLen == 0 || bLen == 0) {
            return 0;
        }
        // why use aLen + 1 here: avoid edge case negative indexes.
        int[][] dp = new int[aLen + 1][bLen + 1];
        
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (A.charAt(i - 1) == B.charAt(j -1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
            }
        }
        // iterate matrix again and find the longest value;
        int max = 0;
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                max = max < dp[i][j]? dp[i][j] : max;
            }
        }
        
        return max;
    }
}
