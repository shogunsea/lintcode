public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n <= 1) {
            return 1;
        }
        // define state: dp[i] ways to get to stair i.
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
        
        
    }
    
    // naive recursion will TLE.
    // public int climbStairs(int n) {
    //     // write your code here
    //     if (n == 1) {
    //         return 1;
    //     } else if (n == 2) {
    //         return 2;
    //     }
        
    //     return climbStairs(n - 1) + climbStairs(n - 2);
    // }
}



public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int first = 1;
        int second = 2;
        int res = 0;
        int stairs = n - 2;
        while (stairs > 0) {
            res = first + second;
            first = second;
            second = res;
            stairs--;
        }
        
        return res;
    }
}