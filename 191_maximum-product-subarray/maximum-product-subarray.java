public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(nums[i], Math.max(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]));
            dp[i][1] = Math.min(nums[i], Math.min(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]));
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}
// 找出一个序列中乘积最大的连续子序列（至少包含一个数）。
//
// 样例
// 比如, 序列 [2,3,-2,4] 中乘积最大的子序列为 [2,3] ，其乘积为6。
