public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n]; //保存每个位置为右下角能找到的最优解
        int max = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
            max = Math.max(max, dp[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i - 1][j - 1] == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1){
                    int length = (int)Math.sqrt(dp[i - 1][j - 1]);
                    int x = 1;
                    while (x <= length && matrix[i - x][j] == 1 && matrix[i][j - x] == 1) {
                        x++;
                    }
                    if (x > length) {
                        dp[i][j] = dp[i - 1][j - 1] + length * 2 + 1;
                    } else {
                        dp[i][j] = matrix[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
// 在一个二维01矩阵中找到全为1的最大正方形
//
// 样例
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
// 返回 4
