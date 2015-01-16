public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        // use one auxiliary array to record current lowest 
        // prices before(left) index i.
        // then scan second time to update max profit.
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        
        int[] leftMin = new int[len];
        int min = prices[0];
        
        for (int i = 1; i < len; i++) {
            leftMin[i] = min;
            int cur = prices[i];
            min = min < cur? min : cur;
        }
        
        int profit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > leftMin[i]) {
                int tempProfit = prices[i] - leftMin[i];
                profit = profit < tempProfit? tempProfit : profit;
            }
        }
        
        return profit;
    }
}


// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for(int i : prices){
            if(min > i){
                min = i;
            }
            if(profit < i - min){
                profit = i - min;
            }
        }       

        return profit;
    }
}