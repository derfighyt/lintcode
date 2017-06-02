/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/minimum-subarray
@Language: Java
@Datetime: 17-05-25 10:08
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (Integer i : nums) {
            sum += i;
            min = Math.min(sum, min);
            sum = Math.min(sum, 0);
        }
        return min;
    }
}
