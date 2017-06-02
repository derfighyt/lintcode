/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/length-of-last-word
@Language: Java
@Datetime: 17-06-02 08:38
*/

public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        if (s == null) {
            return 0;
        }
        int i = s.length() - 1;
        int count = 0;
        while (i >= 0) {
            char c = s.charAt(i--);
            if (c == ' ') {
                if (count == 0) {
                    continue;
                } else {
                    break;
                }
            } else {
                count++;
            }
        }
        return count;
    }
}