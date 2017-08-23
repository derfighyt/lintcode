public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        // Write your code here
        int[][] result = new int[n][n];

        int i = 0, j = -1;
        int loop = 0;
        int num = 1;
        while (num <= n * n) {
            for (i = loop, j += 1; j < n - loop; j++) {
                result[i][j] = num++;
            }
            for (i += 1, j = n - loop - 1; i < n - loop; i++) {
                result[i][j] = num++;
            }
            for (i = n - loop - 1, j -= 1; j >= loop && i > loop; j--) {
                result[i][j] = num++;
            }
            for (j = loop, i -= 1; i > loop && j < n - loop - 1; i--) {
                result[i][j] = num++;
            }
            loop++;
        }
        return result;
    }
}
// 给你一个数n生成一个包含1-n^2的螺旋形矩阵
//
// 样例
// n = 3
// 矩阵为
//
// [
//   [ 1, 2, 3 ],
//   [ 8, 9, 4 ],
//   [ 7, 6, 5 ]
// ]
