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
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        return createTree(A, 0, A.length - 1);
    }

    private TreeNode createTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }

        int index = (end - start) / 2 + start;
        TreeNode node = new TreeNode(A[index]);
        node.left = createTree(A, start, index - 1);
        node.right = createTree(A, index + 1, end);
        return node;
    }
}
