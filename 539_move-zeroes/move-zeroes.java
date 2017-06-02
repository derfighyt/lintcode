/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/move-zeroes
@Language: Java
@Datetime: 17-05-25 10:28
*/

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                if (j <= i) {
                    j = i + 1;
                }
                while (j < nums.length) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        i++;
                        j++;
                        break;
                    } else {
                        j++;
                    }
                }
                if (j >= nums.length) {
                    break;
                }
            } else {
                i++;
            }
        }
    }
}