/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/happy-number
@Language: Java
@Datetime: 17-05-22 06:22
*/

public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        Map <Integer, Integer> map = new HashMap<Integer, Integer>();
        int term = n;
        while (true) {
            int result = 0;
            int m = term;
            while (m > 0) {
                result += (m % 10) * (m % 10);
                m = m / 10;
            }
            if (result == 1) {
                return true;
            } else {
                if (map.containsKey(result)) {
                    return false;
                } else {
                    map.put(result, 0);
                    term = result;
                }
            }
        }
    }
}