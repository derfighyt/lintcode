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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        int sum = 0;
        Stack<TreeNode> stack = new Stack();
        List<String> result = new ArrayList();

        List<Integer> path = new ArrayList();
        TreeNode node = root;
        TreeNode last = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                path.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null) {
                //叶子结点
                if (node.left == null) {
                    result.add(copy(path));
                }
                path.remove(path.size() - 1);
                last = node;
                node = null;
            } else if (node.right == last){
                //右节点刚访问过
                path.remove(path.size() - 1);
                last = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
        return result;
    }

    private String copy(List<Integer> path) {
        StringBuilder result = new StringBuilder();
        for (Integer i : path) {
            result.append(String.valueOf(i)).append("->");
        }
        if (result.length() > 2) {
            result.delete(result.length() - 2, result.length());
        }
        return result.toString();
    }
}
