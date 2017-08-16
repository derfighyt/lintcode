public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // 分治，选中中值，
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int p = n - 1;
        int count = 0;
        while (i < m && p >= 0) {
            if (matrix[i][p] > target) {
                //找第一个小于等于target的
                while (p >= 0 && matrix[i][p] > target) {
                    p--;
                }
            } else if (matrix[i][p] == target) {
                //当前元素等于target，则正下方必然大于target，指针应该移到左下
                count++;
                i++;
                p--;
            } else {
                //当前元素小于target，且右侧元素大于target，则右下也大于target，指针移到正下方
                i++;
            }
        }
        return count;
    }
}

// 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
//
// 这个矩阵具有以下特性：
//
// 每行中的整数从左到右是排序的。
// 每一列的整数从上到下是排序的。
// 在每一行或每一列中没有重复的整数。
// 样例
// 考虑下列矩阵：
//
// [
//     [1, 3, 5, 7],
//     [2, 4, 7, 8],
//     [3, 5, 9, 10]
// ]
//
// 给出target = 3，返回 2
//
// 挑战
// 要求O(m+n) 时间复杂度和O(1) 额外空间
