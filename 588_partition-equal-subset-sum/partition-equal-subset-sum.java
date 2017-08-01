public class Solution {
    /**
     * @param nums a non-empty array only positive integers
     * @return return true if can partition or false
     */
    public boolean canPartition(int[] nums) {
        // Write your code here
        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 == 1 || max > sum / 2) {
            return false;
        }

        return helper(nums, sum / 2, 0, 0);
    }

    public boolean helper(int[] nums, int target, int sum, int i) {//检查数组中是否能找到一组数，和为target
        if (i == nums.length) {
            return false;
        }
        //sum < target
        sum += nums[i];
        if (sum == target) {
            return true;
        } else if (sum > target) {
            sum -= nums[i];
            return helper(nums, target, sum, i + 1);
        } else {
            if (!helper(nums, target, sum, i + 1)) {
                sum -= nums[i];
                return helper(nums, target, sum, i + 1);
            } else {
                return true;
            }
        }
    }
}
// Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
// such that the sum of elements in both subsets is equal.
//
//  注意事项
//
// Each of the array element will not exceed 100.
// The array size will not exceed 200.
//
// 样例
// Given nums = [1, 5, 11, 5], return true
// two subsets: [1, 5, 5], [11]
//
// Given nums = [1, 2, 3, 9], return false
