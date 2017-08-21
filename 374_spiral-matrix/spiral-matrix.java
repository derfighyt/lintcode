public class Solution {
    /*
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // write your code here
        List<Integer> result = new ArrayList();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0, j = -1;
        int loop = 0;
        while (result.size() < m * n) {
            for (i = loop, j += 1; j < n - loop; j++) {
                result.add(matrix[i][j]);
            }
            for (i += 1, j = n - loop - 1; i < m - loop; i++) {
                result.add(matrix[i][j]);
            }
            for (i = m - loop - 1, j -= 1; j >= loop && i > loop; j--) {
                result.add(matrix[i][j]);
            }
            for (j = loop, i -= 1; i > loop && j < n - loop - 1; i--) {
                result.add(matrix[i][j]);
            }
            loop++;
        }
        return result;
    }
};
// 给定一个包含 m x n 个要素的矩阵，（m 行, n 列），按照螺旋顺序，返回该矩阵中的所有要素。
//
// 样例
// 给定如下矩阵：
//
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// 应返回 [1,2,3,6,9,8,7,4,5]。
