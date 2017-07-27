public class Solution {
    /**
     * @param nums: an array of integers
     * @return: An array of integers that's next permuation
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        //与上一题顺序相反，但还是从后面找到第一个逆序数，再从后面找到第一个大于他的数交换，然后翻转后面的序列
        int n = nums.length;
        int[] result = new int[n];
        int i = n - 2, j = n - 1;
        while (i >= 0 && nums[i] >= nums[i + 1]) {//找到第一个逆序数nums[i]
            i--;
        }
        if (i >= 0) {
            //逆序数往后的，找到第一个比逆序数大的数nums[j]，与nums[i]做交换
            while (nums[j] <= nums[i]) {
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        j = 0;
        for (int k = 0; k <= i; k++) {//逆序数往前的都不用动
            result[j++] = nums[k];
        }
        //逆序数往后的，直接翻转
        for (int k = n - 1; k > i; k--) {
            result[j++] = nums[k];
        }
        return result;
    }
}
// 给定一个整数数组来表示排列，找出其之后的一个排列。
//
//  注意事项
//
// 排列中可能包含重复的整数
//
// 样例
// 给出排列[1,3,2,3]，其下一个排列是[1,3,3,2]
//
// 给出排列[4,3,2,1]，其下一个排列是[1,2,3,4]
