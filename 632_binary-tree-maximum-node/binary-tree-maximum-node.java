public class Solution {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        TreeNode maxLeft = maxNode(root.left);
        TreeNode maxRight = maxNode(root.right);

        TreeNode node = root;
        if (maxLeft != null && maxLeft.val > node.val) {
            node = maxLeft;
        }
        if (maxRight != null && maxRight.val > node.val) {
            node = maxRight;
        }
        return node;
    }
}
