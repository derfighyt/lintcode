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
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        int sum = 0;
        Stack<TreeNode> stack = new Stack();
        List<List<Integer>> result = new ArrayList();

        List<Integer> path = new ArrayList();
        TreeNode node = root;
        TreeNode last = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                //此处可以加入剪纸减少时间开销
                sum += node.val;
                path.add(node.val);
                stack.push(node);
                node = node.left;
            }
            //sum = 5, stack = 1 2 2, path = 1 2 2
            node = stack.pop();
            if (node.right == null) {
                //叶子结点
                if (node.left == null && sum == target) {//处理一种只有左节点的特殊情况
                    result.add(copy(path));
                }
                sum -= node.val;
                path.remove(path.size() - 1);
                last = node;
                node = null;
            } else if (node.right == last){
                //右节点刚访问过
                sum -= node.val;
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

    private List<Integer> copy(List<Integer> path) {
        List<Integer> result = new ArrayList();
        for (Integer i : path) {
            result.add(i);
        }
        return result;
    }
}
