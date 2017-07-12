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
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int nodeCount = 0;
        int nextNodeCount = 0;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);
        nodeCount++;
        level++;

        while (nodeCount > 0) {
            while(nodeCount > 0) {
                TreeNode node = queue.poll();
                nodeCount--;
                if (node.left != null) {
                    queue.add(node.left);
                    nextNodeCount++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextNodeCount++;
                }
            }
            if (!queue.isEmpty()) {
                level++;
            }
            nodeCount = nextNodeCount;
            nextNodeCount = 0;
        }
        return level;
    }
}
