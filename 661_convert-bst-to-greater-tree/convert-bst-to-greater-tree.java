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
     * @param root the root of binary tree
     * @return the new root
     */
    public TreeNode convertBST(TreeNode root) {
        // Write your code here
        //二叉查找树，最大的节点在右下，
        //每个节点加上比自己大的数，
        //如果没有父节点或有父节点，自己是右子，等同于自己是根，加上右子树之和
        //如果有父节点，自己是左子，加上根和自己的右子树(根之前已经加过了)
        //有点像反向的中序遍历
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        TreeNode result = root;
        int sum = 0;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }

        return result;
    }
}
