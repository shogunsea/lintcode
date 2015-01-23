public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }

        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] - min > 0) {
                profit = Math.max(profit, prices[i] - min);
            }

            min = prices[i] > min? min : prices[i];
        }

        return profit;

    }
}