class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        
        for (int i = 0; i <= n; i++) {
            count += getCount(k, i);
        }
        
        return count;
    }
    
    public int getCount(int k, int n) {
        int count = 0;
        
        if (n == 0) {
            return k == 0? 1 : count;
        }
        
        while (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit == k) {
                count++;
            }
            n /= 10;
        }
        
        return count;
    }
};

