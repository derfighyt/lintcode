public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        //充分利用参数的数组空间来保存条件。
        if(matrix == null || matrix.length == 0)
            return;

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean empty_row0 = false;
        boolean empty_col0 = false;
        for(int i = 0; i < cols; i++){
            if(matrix[0][i] == 0){
                empty_row0 = true;
                break;
            }
        }

        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0){
                empty_col0 = true;
                break;
            }
        }

        for(int i = 1; i < rows; i++) {
            for(int j =1; j<cols; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i<rows; i++) {
            for (int j=1; j< cols; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        if(empty_row0){
            for(int i = 0; i < cols; i++){
                matrix[0][i] = 0;
            }
        }

        if(empty_col0){
            for(int i = 0; i < rows; i++){
                matrix[i][0] = 0;
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
