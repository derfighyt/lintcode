/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/plus-one
@Language: Java
@Datetime: 17-05-26 06:27
*/

public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        if (digits.length < 1) {
            return digits;
        }
        int i = digits.length - 1;
        while(i >= 0) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
            i--;
        }
        int [] result = new int [digits.length + 1];
        result[0] = 1;
        return result;
    }
}