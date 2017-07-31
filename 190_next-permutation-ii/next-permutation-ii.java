public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        int n = nums.length;
        int i = n - 2, j = n - 1;
        while (i >= 0 && String.valueOf(nums[i]).compareTo(String.valueOf(nums[i + 1])) >= 0) {//找到第一个逆序数nums[i]
            i--;
        }
        if (i >= 0) {
            //逆序数往后的，找到第一个比逆序数大的数nums[j]，与nums[i]做交换
            while (String.valueOf(nums[j]).compareTo(String.valueOf(nums[i])) <= 0) {
                j--;
            }
            swap(nums, i, j);
        }
        //逆序数往后的，直接翻转
        i++;
        j = n - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// 给定一个若干整数的排列，给出按正数大小进行字典序从小到大排序后的下一个排列。
// 如果没有下一个排列，则输出字典序最小的序列。
//
// 样例
// 左边是原始排列，右边是对应的下一个排列。
//
// 1,2,3 → 1,3,2
//
// 3,2,1 → 1,2,3
//
// 1,1,5 → 1,5,1
//
// 挑战
// 不允许使用额外的空间。
