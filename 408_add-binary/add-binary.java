/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/add-binary
@Language: Java
@Datetime: 17-06-02 08:07
*/

public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        String r = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        int flag = 0;
        while (i >= 0 && j >= 0) {
            char ac = a.charAt(i--);
            char bc = b.charAt(j--);
            if (flag == 0) {
                if (ac == bc) {
                    r = "0" + r;
                    if (ac == '1') {
                        flag = 1;
                    }
                } else {
                    r = "1" + r;
                }
            } else {
                if (ac == bc) {
                    r = "1" + r;
                    if (ac == '0') {
                        flag = 0;
                    }
                } else {
                    r = "0" + r;
                }
            }
        }

        while (i >= 0) {
            char ac = a.charAt(i--);
            if (flag == 0) {
                r = ac + r;
            } else {
                if (ac == '0') {
                    r = "1" + r;
                    flag = 0;
                } else {
                    r = "0" + r;
                }
            }
        }

        while (j >= 0) {
            char bc = b.charAt(j--);
            if (flag == 0) {
                r = bc + r;
            } else {
                if (bc == '0') {
                    r = "1" + r;
                    flag = 0;
                } else {
                    r = "0" + r;
                }
            }
        }

        if (flag == 1) {
            r = "1" + r;
        }

        return r;
    }
}