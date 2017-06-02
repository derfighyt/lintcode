/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix
@Language: Java
@Datetime: 17-06-02 02:59
*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }

        //先定位到行
        int a = 0;
        int b = m - 1;
        int x;
        while (a < b) {
            x = (b - a) / 2 + a;
            if (matrix[x][0] > target) {
                b = x - 1;
            } else if (matrix[x][0] < target){
                if (matrix[x][n - 1] < target) {
                    a = x + 1;
                } else {
                    a = x;
                    break;
                }
            } else {
                return true;
            }
        }

        x = a;
        a = 0;
        b = n - 1;
        int y;
        while (a <= b) {
            y = (b - a) / 2 + a;
            if (matrix[x][y] > target) {
                b = y - 1;
            } else if (matrix[x][y] < target) {
                a = y + 1;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
