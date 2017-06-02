/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-arrays
@Language: Java
@Datetime: 17-05-25 10:01
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int m = A.length;
        int n = B.length;
        int [] result = new int [m + n];
        int index = 0;
        int i = 0, j = 0;
        while(i < m && j < n) {
            if (A[i] < B[j]) {
                result[index++] = A[i++];
            } else {
                result[index++] = B[j++];
            }
        }
        if (i < m) {
            for (int k = i; k < m; k++) {
                result[index++] = A[k];
            }
        }
        if (j < n) {
            for (int k = j; k < n; k++) {
                result[index++] = B[k];
            }
        }
        return result;
    }
}