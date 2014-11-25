public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int aLen = s1.length();
        int bLen = s2.length();
        int cLen = s3.length();
        if (aLen == 0 || bLen == 0) {
            return aLen == 0? s2.equals(s3) : s1.equals(s3);
        }
        if (cLen != (aLen + bLen)) {
            return false;
        }
        
        boolean[][] dp = new boolean[aLen + 1][bLen + 1];
        dp[0][0] = true;
        // first row and col for empty string case.
        for (int i = 1; i <= aLen; i++) {
            char a = s1.charAt(i - 1);
            char c = s3.charAt(i - 1);
            if (a == c) {
                dp[i][0] = dp[i - 1][0];
            } else {
                break;
            }
        }
        for (int j = 1; j <= bLen; j++) {
            char b = s2.charAt(j - 1);
            char c = s3.charAt(j - 1);
            if (b == c) {
                dp[0][j] = dp[0][j - 1];
            } else {
                break;
            }
        }
        
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                char a = s1.charAt(i - 1);
                char b = s2.charAt(j - 1);
                char c = s3.charAt(i + j - 1);
                if (a == c || b == c) {
                    dp[i][j] = (a == c && dp[i - 1][j]) || (b == c && dp[i][j - 1]);
                } else {
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[aLen][bLen];

    }
}
