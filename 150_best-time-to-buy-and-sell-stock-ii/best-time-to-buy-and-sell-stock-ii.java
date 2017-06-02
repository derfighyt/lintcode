/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-ii
@Language: Java
@Datetime: 17-05-31 07:34
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
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > lowest) {
                max += (prices[i] - lowest);
            }
            lowest = prices[i];
        }
        return max;
    }
};