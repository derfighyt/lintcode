/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/space-replacement
@Language: Java
@Datetime: 17-06-02 09:21
*/

public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        if (string == null || length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                count++;
            }
        }
        int result = length + count * 2;
        int index = length - 1;
        for (int i = result - 1; i >= 0; i--) {
            if (string[index] != ' ') {
                string[i] = string[index--];
            } else {
                string[i--] = '0';
                string[i--] = '2';
                string[i] = '%';
                index--;
            }
        }
        return result;
    }
}