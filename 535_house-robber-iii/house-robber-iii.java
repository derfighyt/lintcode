/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        // write your code here
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    public int[] helper(TreeNode root) {
        //返回 打劫根节点时的最大值(抛弃左右子节点) 及不打劫根节点时的最大值(左右子节点最大值之和)
        int[] result = new int[2];
        if (root == null) {
            return result;
        }
        int[] leftMax = helper(root.left);
        int[] rightMax = helper(root.right);
        result[0] = root.val + leftMax[1] + rightMax[1];
        result[1] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
        return result;
    }
}
// 在上次打劫完一条街道之后和一圈房屋之后，窃贼又发现了一个新的可以打劫的地方，但这次所有的房子组成的区域比较奇怪，
// 聪明的窃贼考察地形之后，发现这次的地形是一颗二叉树。与前两次偷窃相似的是每个房子都存放着特定金额的钱。
// 你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且当相邻的两个房子同一天被打劫时，该系统会自动报警。
//
// 算一算，如果今晚去打劫，你最多可以得到多少钱，当然在不触动报警装置的情况下。
//
// 样例
//   3
//  / \
// 2   3
//  \   \
//   3   1
// 窃贼最多能偷窃的金钱数是 3 + 3 + 1 = 7.
//
//     3
//    / \
//   4   5
//  / \   \
// 1   3   1
// 窃贼最多能偷窃的金钱数是 4 + 5 = 9.
