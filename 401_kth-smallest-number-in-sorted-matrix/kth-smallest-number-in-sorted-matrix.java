public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        if (k == 1) {
            return matrix[0][0];
        }
        int i1 = 0, j1 = 1; //横向;
        int i2 = 1, j2 = 0; //纵向;
        int count = 1;
        int target = 0;
        while (count < k) {
            if (i1 < m && j1 < n && matrix[i1][j1] <= matrix[i2][j2]) {
                target = matrix[i1][j1];
                count++;
                j1++;
                if (j1 == n) {
                    i1++;
                    j1 = j2 + 1;
                }
            } else if (i2 < m && j2 < n) {
                target = matrix[i2][j2];
                count++;
                i2++;
                if (i2 == m) {
                    j2++;
                    i2 = i1 + 1;
                }
            }
        }
        return target;
    }
}

// 在一个排序矩阵中找从小到大的第 k 个整数。
// 排序矩阵的定义为：每一行递增，每一列也递增。
//
// 样例
// 给出 k = 4 和一个排序矩阵：
//
// [
//   [1 ,5 ,7],
//   [3 ,7 ,8],
//   [4 ,8 ,9],
// ]
// 返回 5。
//
// 挑战
// 使用O(k log n)的方法，n为矩阵的宽度和高度中的最大值。
