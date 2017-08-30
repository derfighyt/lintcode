public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // Write your code here
        // 从底向上的动态规划
        // 模型：前后加上1作为边界，设定边界l和r，dp[l][r]表示l和r之间的气球能得到的最大分数，但不包括l和r
        // 所以最后一个气球为i时，其分数为nums[l] * nums[i] * nums[r]，
        // 之前得到的分数为dp[l][i] + dp[i][r]。
        // k = r - l，从k = 2时，开始规划, 为只打1个气球的结果
        // k = 3时为打两个气球的结果，
        // k=n+1时，为打n个气球的结果，此时求dp[-1][n]即为解
        // 把dp索引往前挪一位，即dp[0][n+1]为解
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];

        int[] tmp = new int[n + 2];
        tmp[0] = 1;
        tmp[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            tmp[i + 1] = nums[i];
        }

        for (int k = 2; k < n + 2; k++) { //区间宽度
            for (int l = 0; l < n + 2 - k; l++) { //左边界，右边界r = l + k
                int r = l + k;
                for (int i = l + 1; i < r; i++) { //i是区间内最后剩下的一个
                    dp[l][r] = Math.max(dp[l][r],
                    tmp[l] * tmp[i] * tmp[r] + dp[l][i] + dp[i][r]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
// 有n个气球，编号为0到n-1，每个气球都有一个分数，存在nums数组中。
// 每次吹气球i可以得到的分数为 nums[left] * nums[i] * nums[right]，
// left和right分别表示i气球相邻的两个气球。当i气球被吹爆后，其左右两气球即为相邻。
// 要求吹爆所有气球，得到最多的分数。
//
// 样例
// 给出 [4, 1, 5, 10]
// 返回 270
//
// nums = [4, 1, 5, 10] burst 1, 得分 4 * 1 * 5 = 20
// nums = [4, 5, 10]    burst 5, 得分 4 * 5 * 10 = 200
// nums = [4, 10]       burst 4, 得分 1 * 4 * 10 = 40
// nums = [10]          burst 10, 得分 1 * 10 * 1 = 10
// 总共的分数为 20 + 200 + 40 + 10 = 270
