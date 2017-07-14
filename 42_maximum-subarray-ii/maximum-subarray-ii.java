public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int n = nums.size();
        int[] leftMax = new int[n];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum);
            leftMax[i] = max;
            if (sum < 0) {
                sum = 0;
            }
        }

        sum = 0;
        max = Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;
        for (int i = n - 1; i > 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum);
            result = Math.max(result, max + leftMax[i - 1]);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }
}

// 给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
// 每个子数组的数字在数组中的位置应该是连续的。
// 返回最大的和。
// 样例
// 给出数组 [1, 3, -1, 2, -1, 2]
// 这两个子数组分别为 [1, 3] 和 [2, -1, 2] 或者 [1, 3, -1, 2] 和 [2]，它们的最大和都是 7
