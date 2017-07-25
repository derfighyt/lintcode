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
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        //做中序遍历
        List<Integer> list = new ArrayList();
        mid(list, root);
        int now = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= now) {
                return false;
            }
            now = list.get(i);
        }
        return true;
    }

    public void mid(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        mid(list, root.left);
        list.add(root.val);
        mid(list, root.right);
    }

}
// 给定一个二叉树，判断它是否是合法的二叉查找树(BST)
//
// 一棵BST定义为：
//
// 节点的左子树中的值要严格小于该节点的值。
// 节点的右子树中的值要严格大于该节点的值。
// 左右子树也必须是二叉查找树。
// 一个节点的树也是二叉查找树。
//
// 样例
// 一个例子：
//
//   2
//  / \
// 1   4
//    / \
//   3   5
// 上述这棵二叉树序列化为 {2,1,4,#,#,3,5}.
