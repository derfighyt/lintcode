/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/valid-palindrome
@Language: Java
@Datetime: 17-06-02 10:01
*/

public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        int a = 0;
        int b = s.length() - 1;
        while (true) {
            while(a < s.length() && !valid(s.charAt(a))) {
                a++;
            }
            while(b >=0 && !valid(s.charAt(b))) {
                b--;
            }
            if (a < b) {
                if (!equals(s.charAt(a++), s.charAt(b--))) {
                    return false;
                }
            } else {
                break;
            }
        }
        return true;
    }

    public boolean valid(char c) {
        if (c >= '0' && c <= 'z') {
            return true;
        }
        return false;
    }

    public boolean equals(char a, char b) {
        if (a == b) {
            return true;
        } else {
            if (a >= 'a') {
                a = (char)(a - 32);
            }
            if (b >= 'a') {
                b = (char)(b - 32);
            }
            return a == b;
        }
    }
}