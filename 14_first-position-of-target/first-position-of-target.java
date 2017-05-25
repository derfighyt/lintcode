/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 17-05-24 08:31
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        return doSearch(nums, target, 0, nums.length - 1);
    }

    private int doSearch(int[] nums, int target, int start, int end) {
        if (end < start) {
            return -1;
        }
        if (end == start) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        if (end > start) {
            int middle = start + (end - start) / 2;
            if (nums[middle] > target) {
                return doSearch(nums, target, start, middle - 1);
            } else if (nums[middle] == target) {
                if (middle == 0 || nums[middle - 1] < target) {
                    return middle;
                } else {
                    return doSearch(nums, target, start, middle - 1);
                }
            } else {
                return doSearch(nums, target, middle + 1, end);
            }
        }
        return -1;
    }
}