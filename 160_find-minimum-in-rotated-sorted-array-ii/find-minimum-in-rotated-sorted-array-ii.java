public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (start + 1 == end) {
            return Math.min(nums[start], nums[end]);
        }
        int mid = start + (end - start) / 2;
        int index = mid;
        while (index < end && nums[index] <= nums[index + 1]) {
            index++;
        }
        if (index < end) {
            return helper(nums, mid, end);
        } else {
            return helper(nums, start, mid);
        }
    }
}
