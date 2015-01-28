class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int len = prices.length;
        if (len == 0) {
            return 0;
        }

        int maxProfit = 0;
        int[] leftProfit = new int[len];
        int min = prices[0];
        int tempProfit = 0;

        for (int i = 1; i < len; i++) {
            tempProfit = Math.max(tempProfit, prices[i] - min);
            leftProfit[i] = tempProfit;
            min = prices[i] < min? prices[i] : min;
        }
        
        int max = prices[len - 1];
        tempProfit = 0;

        for (int i = len - 2; i >= 0; i--) {
            tempProfit = Math.max(tempProfit, max - prices[i]);
            maxProfit = Math.max(maxProfit, tempProfit + leftProfit[i]);
            max = max < prices[i]? prices[i] : max;
        }
        
        return maxProfit;
        
    }
};
