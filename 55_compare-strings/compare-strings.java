/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/compare-strings
@Language: Java
@Datetime: 17-06-02 08:15
*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        int [] map = new int[26];
        for (int i = 0; i < A.length(); i++) {
            int c = (int)(A.charAt(i) - 'A');
            map[c]++;
        }
        for (int i = 0; i < B.length(); i++) {
            int c = (int)(B.charAt(i) - 'A');
            if (map[c] == 0) {
                return false;
            } else {
                map[c]--;
            }
        }
        return true;
    }
}