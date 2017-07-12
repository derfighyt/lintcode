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
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        List<TreeNode> result = buildTree(1, n);
        return result;
    }

    public List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> result = new ArrayList();
        if (start > end) {
            result.add(null);
        } else if (start == end) {
            result.add(new TreeNode(start));
        } else if (start < end) {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftList = buildTree(start, i - 1);
                List<TreeNode> rightList = buildTree(i + 1, end);
                for (TreeNode left : leftList) {
                    for (TreeNode right : rightList) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }
}
