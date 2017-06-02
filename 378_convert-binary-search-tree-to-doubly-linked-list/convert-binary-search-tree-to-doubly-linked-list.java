/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/convert-binary-search-tree-to-doubly-linked-list
@Language: Java
@Datetime: 17-06-01 10:22
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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode result = dummy;
        run(result, root);
        dummy.next.prev = null;
        return dummy.next;
    }

    public DoublyListNode run(DoublyListNode list, TreeNode node) {
        if (node == null) {
            return list;
        }

        if (node.left != null) {
            list = run(list, node.left);
        }

        list.next = new DoublyListNode(node.val);
        list.next.prev = list;
        list = list.next;

        if (node.right != null) {
            list = run(list, node.right);
        }
        return list;
    }
}
