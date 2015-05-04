public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordSegmentation(String s, Set<String> dict) {
        // write your code here   
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        
        
        // Last test case is SICK
        // without this validation it wont pass.
        int[] count = new int[26];
        for (String ss : dict) {
            for (int i = 0; i < ss.length(); i++) {
                count[ss.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 0) {
                return false;
            }
        }
        
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0 ;j--) {
                if (!dp[j]) continue;
                String sub = s.substring(j, i);
                if (dict.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
