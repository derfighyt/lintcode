public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int n = nums.length;
        int start = 0, end = 0;
        int count = Integer.MAX_VALUE, sum = 0;
        while (end < n) {
            sum += nums[end++];
            while (sum >= s) {
                count = Math.min(count, end - start + 1);
                sum -= nums[start++];
            }
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }
}
// 给定一个由 n 个整数组成的数组和一个正整数 s ，请找出该数组中满足其和 ≥ s 的最小长度子数组。如果无解，则返回 -1。
//
// 样例
// 给定数组 [2,3,1,2,4,3] 和 s = 7, 子数组 [4,3] 是该条件下的最小长度子数组。
//
// 挑战
// 如果你已经完成了O(n)时间复杂度的编程，请再试试 O(n log n)时间复杂度。
