public class Solution {
    /**
     * @param nums an array containing n + 1 integers which is between 1 and n
     * @return the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // Write your code here
        return helper(nums, 1, nums.length);
    }

    public int helper(int[] nums, int min, int max) {//逐步缩小重复的数所在的区间，类似于快排的思路，复杂度应该是nlogn
        //快慢下标找环挺牛，on的复杂度
        int small = 0;
        int big = 0;
        int equal = 0;
        int mid = (min + max) / 2;
        for (int num : nums) {
            if (num < mid) {
                small++;
                if (small > mid - 1) {//最多应该有mid - 1个数小于mid，否则重复数在min - max区间内
                    return helper(nums, min, mid - 1);
                }
            } else if (num > mid) {
                big++;
                if (big > nums.length - mid - 1) {//最多应该有n - mid个数大于mid，否则重复数在mid - max区间内
                    return helper(nums, mid + 1, max);
                }
            } else {//找到重复
                equal++;
                if (equal > 1) {
                    return mid;
                }
            }
        }
        return 0;
    }
}

// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
// prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
// find the duplicate one.
//
//  注意事项
//
// You must not modify the array (assume the array is read only).
// You must use only constant, O(1) extra space.
// Your runtime complexity should be less than O(n^2).
// There is only one duplicate number in the array, but it could be repeated more than once.
// 样例
// Given nums = [5,5,4,3,2,1] return 5
// Given nums = [5,4,4,3,2,1] return 4
