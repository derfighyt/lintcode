/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/unique-paths-ii
@Language: Java
@Datetime: 17-05-31 06:32
*/

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        if (m == 0 || obstacleGrid[0].length == 0) {
            return 1;
        }
        int n = obstacleGrid[0].length;
        int [][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            sum[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            sum[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    sum[i][j] = 0;
                } else {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
                }
            }
        }
        return sum[m - 1][n - 1];
    }
}