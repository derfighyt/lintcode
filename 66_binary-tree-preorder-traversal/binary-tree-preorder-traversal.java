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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        if(root == null) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node == null) {
                node = stack.pop();
            }
            if (node != null) {
                result.add(node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            node = node.left;
        }

        return result;
    }
}
