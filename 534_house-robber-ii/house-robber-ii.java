public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int dp1 = nums[0];
        int dp2 = Math.max(nums[0], nums[1]);
        if (n > 2) {
            //边界处理
            //1. 如果抛弃最后一个，则结果为前n-1个的结果
            //2. 如果要保留最后一个，则n-1不能保留，0也不能保留，结果为 1 - (n-2)的结果
            dp2 = Math.max(helper(nums, 0, n - 1),
                            helper(nums, 1, n - 2) + nums[n - 1]);

        }

        return dp2;
    }

    public int helper(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int dp1 = nums[start];
        int dp2 = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int dp = Math.max(dp1 + nums[i], dp2);
            dp1 = dp2;
            dp2 = dp;
        }
        return dp2;
    }
}

// 在上次打劫完一条街道之后，窃贼又发现了一个新的可以打劫的地方，但这次所有的房子围成了一个圈，
// 这就意味着第一间房子和最后一间房子是挨着的。每个房子都存放着特定金额的钱。
// 你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
//
// 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，你最多可以得到多少钱 在不触动报警装置的情况下。
//
//  注意事项
//
// 这题是House Robber的扩展，只不过是由直线变成了圈
// 样例
// 给出nums = [3,6,4], 返回　6，　你不能打劫3和4所在的房间，因为它们围成一个圈，是相邻的．
