/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/partition-array-by-odd-and-even
@Language: Java
@Datetime: 17-05-26 06:02
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] % 2 == 0) {
                while (right >= left) {
                    if (nums[right] % 2 == 1) {
                        nums[left] += nums[right];
                        nums[right] = nums[left] - nums[right];
                        nums[left] = nums[left] - nums[right];
                        right--;
                        break;
                    } else {
                        right--;
                    }
                }
            }
            left++;
        }
    }
}