public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> result = new ArrayList();
        if (n == 0) {
            return result;
        }

        long[][] dp = new long[n + 1][6*n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        long total = 6; //n=1的特殊情况
        for (int i = 2; i <= n; i++) { //第i个骰子
            total = 0;
            for (int j = 1 * i; j <= 6 * i; j++) { //出现值j的次数
                for (int k = 1; k <= 6 && k < j; k++) { //第i个骰子取值k的时候
                    dp[i][j] += dp[i - 1][j - k];
                }
                total += dp[i][j];
            }
        }

        for (int i = n; i <= 6 * n; i++) {
            result.add(new AbstractMap.SimpleEntry<Integer, Double>(i, (double)dp[n][i]/total));
        }
        return result;
    }
}
// 扔 n 个骰子，向上面的数字之和为 S。给定 Given n，请列出所有可能的 S 值及其相应的概率。
//
//  注意事项
//
// You do not care about the accuracy of the result, we will help you to output results.
//
// 样例
// 给定 n = 1，返回 [ [1, 0.17], [2, 0.17], [3, 0.17], [4, 0.17], [5, 0.17], [6, 0.17]]。
