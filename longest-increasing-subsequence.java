public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        
        int max = 0;
        int[] dp = new int[len];
        
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j  = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    dp[i] = dp[i] < dp[j] + 1? dp[j] + 1 : dp[i];
                }
            }
            max = max < dp[i]? dp[i] : max;
        }
        
        return max;
    }
}

