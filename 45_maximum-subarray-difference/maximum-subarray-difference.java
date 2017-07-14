public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //[1, 2, -3, 1]
        //[1, 3,  3, 3] max
        //[1, -3, -3, 1] min
        int n = nums.length;
        int sum1 = 0;
        int sum2 = 0;
        int [] maxArray = new int[n];
        int [] minArray = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            //计算前i个数里，子数组的最大和最小和
            sum1 += nums[i];
            max = Math.max(max, sum1);
            maxArray[i] = max;
            if (sum1 < 0) {
                sum1 = 0;
            }
            sum2 += nums[i];
            min = Math.min(min, sum2);
            minArray[i] = min;
            if (sum2 > 0) {
                sum2 = 0;
            }
        }
        sum1 = 0;
        sum2 = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        for (int i = n - 1; i > 0; i--) {
            //从后面开始，算子数组最小最大和，并和前面的值做差
            sum1 += nums[i];
            min = Math.min(min, sum1);
            result = Math.max(result, Math.abs(maxArray[i - 1] - min));
            if (sum1 > 0) {
                sum1 = 0;
            }
            sum2 += nums[i];
            max = Math.max(max, sum2);
            result = Math.max(result, Math.abs(minArray[i - 1] - max));
            if (sum2 < 0) {
                sum2 = 0;
            }
        }

        return result;
    }
}

// 给定一个整数数组，找出两个不重叠的子数组A和B，
// 使两个子数组和的差的绝对值|SUM(A) - SUM(B)|最大。
// 返回这个最大的差值。
// 注意事项
// 子数组最少包含一个数
//
// 样例
// 给出数组[1, 2, -3, 1]，返回 6
