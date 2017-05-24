/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/longest-palindrome
@Language: Java
@Datetime: 17-05-22 08:51
*/

public class Solution {
    /**
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // Write your code here
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            int count = map.get(c) == null ? 0 : map.get(c);
            map.put(c, count + 1);
        }
        int result = 0;
        int single = 0;
        for (int c : map.values()) {
            if (c % 2 == 1) {
                single = 1;
            }
            result += c/2;
        }
        result *= 2;
        return result + single;
    }
}