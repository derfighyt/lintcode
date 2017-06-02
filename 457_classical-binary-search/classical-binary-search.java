/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/classical-binary-search
@Language: Java
@Datetime: 17-06-02 05:30
*/

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            int x = (e - s) / 2 + s;
            if (nums[x] < target) {
                s = x + 1;
            } else if (nums[x] > target) {
                e = x - 1;
            } else {
                return x;
            }
        }
        return nums[s] == target ? s : -1;
    }
}