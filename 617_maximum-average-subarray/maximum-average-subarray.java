public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double max = Integer.MIN_VALUE;
        int n = nums.length;
        //先计算前k个数的平均值(构建长度为k的窗口)
        double sum = 0;
        int end = 0;
        while (end < k) {
            sum += nums[end++];
        }
        double avg = sum / k;
        max = Math.max(max, avg);

        //窗口后部逐渐往后移动，并同时判断窗口前部是否需要移动
        int start = 0;
        double sumFront = 0;
        while (end < n) {
            //后移一格
            sum += nums[end++];
            sumFront += nums[end - 1 - k];
            //如果窗口前部移动后平均值会变大，说明前部的数字已经拖低了结果，可以移动了
            if ((sum - sumFront) / k > sum / (end - start)) {
                sum -= sumFront;
                sumFront = 0;
                start = end - k;
            }
            avg = sum / (end - start);
            if (avg > max) {
                max = Math.max(max, avg);
                //System.out.println("start : " + start + ", end : " + end + ", avg : " + avg);
            }
        }
        //System.out.println("start : " + start);
        //System.out.println("end : " + end);
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
