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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (inorder == null || preorder == null) {
            return null;
        }
        //前序第一个元素是根
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        //中序根前面的是左树，后面是右树，找到中序里根的位置
        int i = 0;
        for (i = 0; i < n; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        root.left = helper(inorder, preorder, 0, i - 1);
        root.right = helper(inorder, preorder, i + 1, n - 1);
        return root;
    }

    public TreeNode helper(int[] inorder, int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        //在inorder的start - end范围内，找到一个点，在preorder里位置最靠前的，就是当前子树的根
        int indexI = Integer.MAX_VALUE;
        int indexP = Integer.MAX_VALUE;
        int val = 0;
        for (int i = start; i <= end; i++) {
            for (int j = 0; j < preorder.length; j++) {
                if (preorder[j] == inorder[i]) {
                    if (j <= indexP){
                        indexP = j;
                        indexI = i;
                        val = preorder[j];
                    }
                    break;
                }
            }
        }
        TreeNode node = new TreeNode(val);
        node.left = helper(inorder, preorder, start, indexI - 1);
        node.right = helper(inorder, preorder, indexI + 1, end);
        return node;
    }
}
