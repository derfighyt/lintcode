/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iii
@Language: Java
@Datetime: 17-05-31 08:55
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                int profit = maxProfit(prices, 0, i - 1)
                 + maxProfit(prices, i, prices.length - 1);
                max = Math.max(max, profit);
            }
        }
        if (max == 0) {
            max = maxProfit(prices, 0, prices.length - 1);
        }
        return max;
    }

    private int maxProfit(int [] prices, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int max = 0;
        int lowest = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (prices[i] <= lowest) {
                lowest = prices[i];
            } else {
                max = Math.max(max, prices[i] - lowest);
            }
        }
        return max;
    }
};