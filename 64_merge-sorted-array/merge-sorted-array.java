/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Java
@Datetime: 17-05-25 08:48
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B [j]) {
                A[i + j + 1] = A[i--];
            } else {
                A[i + j + 1] = B[j--];
            }
        }
        for (int k = j; k >= 0; k--) {
            A[k] = B[k];
        }
    }
}