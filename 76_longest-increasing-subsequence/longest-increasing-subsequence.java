public class Solution {

    int max = 0;
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n]; //以每个位置为结束，所能找到的最优解。
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            //计算出每个位置的最优解
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
// 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
//
// 说明
// 最长上升子序列的定义：
//
// 最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的由低到高排列的子序列，这种子序列不一定是连续的或者唯一的。
// https://en.wikipedia.org/wiki/Longest_increasing_subsequence
//
// 样例
// 给出 [5,4,1,2,3]，LIS 是 [1,2,3]，返回 3
// 给出 [4,2,4,5,3,7]，LIS 是 [2,4,5,7]，返回 4
//
// 挑战
// 要求时间复杂度为O(n^2) 或者 O(nlogn)
