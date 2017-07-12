/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        int leftVal = maxPath(root.left);
        int rightVal = maxPath(root.right);
        max = Math.max(max, leftVal + root.val + rightVal);
        //根节点不需要返回上层
        return max;
    }

    public int maxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftVal = maxPath(node.left); //左侧最大和
        int rightVal = maxPath(node.right); //右侧最大和
        max = Math.max(max, leftVal + node.val + rightVal); //计算当前子树内能存在的最大和
        int result = Math.max(leftVal + node.val, rightVal + node.val); //如果返回上层，能提供的最大值
        result = Math.max(0, result);
        return result;
    }
}
