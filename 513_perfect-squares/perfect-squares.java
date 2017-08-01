public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        // Write your code here
        int[] dp = new int[n+1]; //0-n的最优解
        dp[0] = 0;

        List<Integer> power = new ArrayList();
        power.add(1);
        int base = 2;

        for (int j = 1; j <= n; j++) {
            if (base * base <= j) {
                power.add(base * base);
                base++;
            }
            dp[j] = Integer.MAX_VALUE;
            for (int num : power) {
                if (dp[j - num] + 1 < dp[j]) {
                    dp[j] = dp[j - num] + 1;
                }
            }
        }
        return dp[n];
    }
}
// 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n。你需要让平方数的个数最少。
//
// 样例
// 给出 n = 12, 返回 3 因为 12 = 4 + 4 + 4。
// 给出 n = 13, 返回 2 因为 13 = 4 + 9。
