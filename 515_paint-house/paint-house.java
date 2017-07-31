public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        // 为了过一组会超时的恶心数据也是拼了
        int n = costs.length;
        int[][] dp = new int[n + 2][3]; //第n个房子，染每种颜色，得到的最小费用
        int i = 1, j = n;
        while (i < j) {
            helper(costs, dp, i, i - 1);
            helper(costs, dp, j, j + 1);
            i++;
            j--;
        }
        int min = Integer.MAX_VALUE;
        if (i == j) {
            min = Math.min(min, costs[i-1][0] + Math.min(dp[i-1][1], dp[i-1][2]) + Math.min(dp[i+1][1], dp[i+1][2]));
            min = Math.min(min, costs[i-1][1] + Math.min(dp[i-1][0], dp[i-1][2]) + Math.min(dp[i+1][0], dp[i+1][2]));
            min = Math.min(min, costs[i-1][2] + Math.min(dp[i-1][0], dp[i-1][1]) + Math.min(dp[i+1][0], dp[i+1][1]));
        } else {//i > j
            min = Math.min(min, dp[i][0] + Math.min(dp[j][1], dp[j][2]));
            min = Math.min(min, dp[i][1] + Math.min(dp[j][0], dp[j][2]));
            min = Math.min(min, dp[i][2] + Math.min(dp[j][0], dp[j][1]));
        }
        return min;
    }

    public void helper(int[][] costs, int[][] dp, int i, int j) {
        dp[i][1] = costs[i-1][1] + Math.min(dp[j][0], dp[j][2]);
        dp[i][0] = costs[i-1][0] + Math.min(dp[j][1], dp[j][2]);
        dp[i][2] = costs[i-1][2] + Math.min(dp[j][0], dp[j][1]);
    }
}
// 这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。
// 每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小。
// 费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用。
//
//  注意事项
// 所有费用都是正整数
//
// 样例
// costs = [[14,2,11],[11,14,5],[14,3,10]] return 10
//
// 房屋 0 蓝色, 房屋 1 绿色, 房屋 2 蓝色， 2 + 5 + 3 = 10
