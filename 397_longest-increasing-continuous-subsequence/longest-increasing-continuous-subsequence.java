/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/longest-increasing-continuous-subsequence
@Language: Java
@Datetime: 17-05-24 08:49
*/

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A.length == 0) {
            return 0;
        }
        int max = 1;
        int last = A[0];
        int count = 1;
        boolean crease = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > last) {
                if (crease) {
                    count++;
                } else {
                    crease = true;
                    count = 2;
                }
            } else {
                if (crease) {
                    crease = false;
                    count = 2;
                } else {
                    count++;
                }
            }
            last = A[i];
            if (count > max) {
                max = count;
            }
        }

        return max;
    }
}