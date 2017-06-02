/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/string-permutation
@Language: Java
@Datetime: 17-06-02 09:31
*/

public class Solution {
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {
        // Write your code here
        if (A.length() != B.length()) {
            return false;
        }

        char [] a = A.toCharArray();
        char [] b = B.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        String tmp1 = new String(a);
        String tmp2 = new String(b);
        return (tmp1.equals(tmp2));
    }
}