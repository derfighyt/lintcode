/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/rotate-string
@Language: Java
@Datetime: 17-06-02 09:10
*/

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0 || offset == 0) {
            return;
        }
        int n = offset % str.length;
        reverse(str, 0, str.length - 1);
        reverse(str, 0, n - 1);
        reverse(str, n, str.length - 1);
    }

    public void reverse(char[] str, int a, int b) {
        int s = a;
        int e = b;
        while (s < e) {
            char c = str[s];
            str[s++] = str[e];
            str[e--] = c;
        }
    }
}