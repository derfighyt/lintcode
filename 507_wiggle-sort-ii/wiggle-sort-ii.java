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
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                } else if (nums[i] == nums[i + 1]){
                    
                }
            } else {
                if (nums[i] < nums[i + 1]) {
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
// 给你一个数组nums，将它重排列如下形式
//
// nums[0] < nums[1] > nums[2] < nums[3]....
//  注意事项
//
// 你可以认为每个输入都有合法解
//
// 样例
// 给出 nums = [1, 5, 1, 1, 6, 4],一种方案为 [1, 4, 1, 5, 1, 6].
//
// 给出 nums = [1, 3, 2, 2, 3, 1],一种方案为 [2, 3, 1, 3, 1, 2].
//
// 挑战
// O(N)时间复杂度 O(1)额外空间
