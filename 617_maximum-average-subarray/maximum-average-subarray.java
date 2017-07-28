public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double max = Double.MIN_VALUE;
        int n = nums.length;
        for (int i = k; i <= n; i++) {
            long sum = 0;
            int j = 0;
            for (j = 0; j < i; j++){
                sum += nums[j];
            }
            max = Math.max(max, (double)sum / i);
            while (j < n) {
                sum -= nums[j - i];
                sum += nums[j++];
                max = Math.max(max, (double)sum / i);
            }
        }
        return max;
    }
}
// 给出一个整数数组，有正有负。找到这样一个子数组，他的长度大于等于 k，且平均值最大。
//
//  注意事项
//
// 保证数组的大小 >= k
//
// 样例
// 给出 nums = [1, 12, -5, -6, 50, 3], k = 3
//
// 返回 15.667 // (-6 + 50 + 3) / 3 = 15.667
