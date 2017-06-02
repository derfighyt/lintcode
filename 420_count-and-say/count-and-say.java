/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/count-and-say
@Language: Java
@Datetime: 17-06-02 08:33
*/

public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        String num = "1";
        String next = "";
        for (int i = 1; i < n; i++) {
            char c = num.charAt(0);
            int count = 1;
            for (int j = 1; j < num.length(); j++) {
                if (num.charAt(j) == c) {
                    count++;
                } else {
                    next = next + count + c;
                    c = num.charAt(j);
                    count = 1;
                }
            }
            next = next + count + c;
            num = next;
            next = "";
        }
        return num;
    }
}