public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return ;
        }
        if (nums[0] > nums[1]) {
            swap(nums, 0, 1);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (i % 2 == 1) {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// 给你一个没有排序的数组，请将原数组就地重新排列满足如下性质
//
// nums[0] <= nums[1] >= nums[2] <= nums[3]....
//  注意事项
//
// 请就地排序数组，也就是不需要额外数组
//
// 样例
// 给出数组为 nums = [3, 5, 2, 1, 6, 4] 一种输出方案为 [1, 6, 2, 5, 3, 4]
