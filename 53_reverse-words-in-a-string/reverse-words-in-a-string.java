/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/reverse-words-in-a-string
@Language: Java
@Datetime: 17-06-02 09:01
*/

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if (s == null || s.length() == 0) {
            return s;
        }
        String [] array = s.split(" ");
        StringBuilder r = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            r.append(array[i]).append(" ");
        }
        if (r.length() > 0) {
            r = r.deleteCharAt(r.length() - 1);
        }
        
        return r.toString();
    }
}
