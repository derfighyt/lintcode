/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/median
@Language: Java
@Datetime: 17-05-24 10:16
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        return nums[(nums.length - 1) / 2];
    }
}
