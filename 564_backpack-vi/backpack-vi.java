public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
        // Write your code here
        if (target <= 0 || nums == null || nums.length <= 0) {
            return 0;
        }
        int n = nums.length;

        int[][] result = new int[n][target];
        //初始化
        Arrays.sort(nums);
        for (int j = 0; j < target; j++) {
            if (j + 1 < nums[0]) {
                result[0][j] = 0;
            } else if (j + 1 == nums[0]) {
                result[0][j] = 1;
            } else {
                result[0][j] = result[0][j - nums[0]];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < target; j++) {
                if (j + 1 < nums[i]) {
                    result[i][j] = result[i - 1][j];
                } else if (j + 1 == nums[i]) {
                    result[i][j] = result[i - 1][j] + 1;
                } else {
                    result[i][j] += result[i][j - nums[i]];
                    for (int k = 0; k < i; k++) {
                        result[i][j] += result[i][j - nums[k]];
                    }
                }
            }
        }

        return result[n - 1][target - 1];
    }
}
