public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int n = A.size();
        int[][] dp = new int[n + 1][101];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;//含义是把第i个数字调整为j，需要的最小代价是正无穷
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 100; j++) {
                if (dp[i - 1][j] != Integer.MAX_VALUE) {//如果把前一个数字调整为j，代价不是正无穷
                    for (int k = 0; k <= 100; k++) {//尝试把当前元素调整为k，且j和k的差值不超过target
                        if (Math.abs(j - k) <= target) {
                            if (dp[i - 1][j] + Math.abs(A.get(i - 1) - k) < dp[i][k]) {
                                dp[i][k] = dp[i - 1][j] + Math.abs(A.get(i - 1) - k);
                            }
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {//最后一个数肯定会调整为0-100中的一个
            min = Math.min(min, dp[n][i]);
        }
        return min;
    }
}
// 给一个整数数组，调整每个数的大小，使得相邻的两个数的差不大于一个给定的整数target，
// 调整每个数的代价为调整前后的差的绝对值，求调整代价之和最小是多少。
//
//  注意事项
//
// 你可以假设数组中每个整数都是正整数，且小于等于100。
//
// 样例
// 对于数组[1, 4, 2, 3]和target=1，最小的调整方案是调整为[2, 3, 2, 3]，调整代价之和是2。返回2。
