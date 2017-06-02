/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/palindrome-number
@Language: Java
@Datetime: 17-06-02 08:49
*/

public class Solution {
    /**
     * @param num a positive number
     * @return true if it's a palindrome or false
     */
    public boolean palindromeNumber(int num) {
        // Write your code here
        String tmp = String.valueOf(num);
        char [] array = tmp.toCharArray();
        int s = 0;
        int e = tmp.length() - 1;
        while (s < e) {
            char c = array[s];
            array[s++] = array[e];
            array[e--] = c;
        }
        String tmp1 = new String(array);
        if (tmp.equals(tmp1)) {
            return true;
        }
        return false;
    }
}