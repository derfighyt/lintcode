/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/two-strings-are-anagrams
@Language: Java
@Datetime: 17-06-02 09:40
*/

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s.length() != t.length()) {
            return false;
        }

        int [] count = new int [256];
        for (int i = 0; i < s.length(); i++) {
            count[(int)s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[(int)t.charAt(i)]--;
            if (count[(int)t.charAt(i)] < 0) {
                return false;
            } 
        }
        return true;
    }
};