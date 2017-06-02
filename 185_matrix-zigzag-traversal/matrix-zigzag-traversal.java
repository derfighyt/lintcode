/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/matrix-zigzag-traversal
@Language: Java
@Datetime: 17-06-02 02:39
*/

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int i = 0; int j = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        if (m == 1) {
            return matrix[0];
        }
        
        int [] result = new int [m * n];
        int d = 0;
        for (int k = 0; k < m * n; k++) {
            result[k] = matrix[i][j];
            if (d == 0) {
                i--;
                j++;
                if (j == n) {
                    j = n -1;
                    d = 1;
                    i = i + 2;
                }
                if (i < 0) {
                    i = 0;
                    d = 1;
                }
            } else {
                i++;
                j--;
                if (i == m) {
                    i = m - 1;
                    d = 0;
                    j = j + 2;
                }
                if (j < 0) {
                    j = 0;
                    d = 0;
                }
            }
        }
        
        return result;
    }
}