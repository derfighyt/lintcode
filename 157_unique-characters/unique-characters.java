/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/unique-characters
@Language: Java
@Datetime: 17-05-27 08:54
*/

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}