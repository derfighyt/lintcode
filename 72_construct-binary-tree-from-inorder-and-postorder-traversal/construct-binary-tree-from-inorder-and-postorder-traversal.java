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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder == null || postorder == null) {
            return null;
        }
        //后续最后一个元素是根
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[n - 1]);
        //中序根前面的是左树，后面是右树，找到中序里根的位置
        int i = 0;
        for (i = 0; i < n; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        root.left = helper(inorder, postorder, 0, i - 1);
        root.right = helper(inorder, postorder, i + 1, n - 1);
        return root;
    }

    public TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        //在inorder的start - end范围内，找到一个点，在postorder里位置最靠后的，就是当前子树的根
        int indexI = 0;
        int indexP = 0;
        int val = 0;
        for (int i = start; i <= end; i++) {
            for (int j = postorder.length - 1; j >= 0; j--) {
                if (postorder[j] == inorder[i]) {
                    if (j >= indexP){
                        indexP = j;
                        indexI = i;
                        val = postorder[j];
                    }
                    break;
                }
            }
        }
        TreeNode node = new TreeNode(val);
        node.left = helper(inorder, postorder, start, indexI - 1);
        node.right = helper(inorder, postorder, indexI + 1, end);
        return node;
    }
}
