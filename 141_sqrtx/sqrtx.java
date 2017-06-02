/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 17-06-02 07:29
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        int s = 0;
        int e = x;
        while (s < e) {
            int n = (e - s) / 2 + s;
            long power = (long)n * n;
            if (power == x) {
                return n;
            } else if (power < x) {
                s = n + 1;
            } else {
                e = n - 1;
            }
        }

        long power = (long)s * s;
        if (power == x) {
            return s;
        } else if (power > x) {
            return (s - 1);
        } else {
            power = (long)(s+1) * (s+1);
            if (power > x) {
                return s;
            } else {
                return (s + 1);
            }
        }
    }
}