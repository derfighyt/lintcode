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
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
            TreeNode node = root.left;
            while (node.right != null) {
                node = node.right;
            }
            node.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
