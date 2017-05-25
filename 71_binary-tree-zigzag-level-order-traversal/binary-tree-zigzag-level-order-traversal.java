/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal
@Language: Java
@Datetime: 17-05-24 06:43
*/

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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int currentCount = 0;
        int childCount = 0;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root != null) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            queue.add(root);
            currentCount++;
            TreeNode node = queue.poll();
            while(node != null) {
                currentCount--;
                if (level % 2 == 1) {
                    temp.add(node.val);
                } else {
                    temp.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                    childCount++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    childCount++;
                }
                if (currentCount <= 0) {
                    result.add(temp);
                    temp = new ArrayList<Integer>();
                    currentCount = childCount;
                    childCount = 0;
                    level++;
                }
                node = queue.poll();
            }
        }

        return result;
    }
}