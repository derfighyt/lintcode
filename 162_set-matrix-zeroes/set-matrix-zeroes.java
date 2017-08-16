public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;

        //m+n
        Set<Integer> xset = new HashSet();
        Set<Integer> yset = new HashSet();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if
            }
        }

    }
}
// 给定一个m×n矩阵，如果一个元素是0，则将其所在行和列全部元素变成0。
//
// 需要在原矩阵上完成操作。
//
// 样例
// 给出一个矩阵
//
// [
//   [1, 2],
//   [0, 3]
// ]
// 返回
//
// [
//   [0, 2],
//   [0, 0]
// ]
// 挑战
// 你是否使用了额外的空间？
// 一个直接的解决方案是使用 O(MN) 的额外空间，但这并不是一个好的方案。
// 一个简单的改进方案是使用 O(M + N) 的额外空间，但这仍然不是最好的解决方案。
// 你能想出一个常数空间的解决方案吗？
