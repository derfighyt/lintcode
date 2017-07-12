/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        //获得链表长度
        ListNode node = head;
        int n = 0;
        while (node != null) {
            n++;
            node = node.next;
        }

        TreeNode root = buildTree(head, n);
        return root;
    }

    public TreeNode buildTree(ListNode head, int size) {
        if (size <= 0 || head == null) {
            return null;
        }
        int i = 0;
        ListNode node = head;
        while (i < (size / 2)) {
            node = node.next;
            i++;
        }
        TreeNode result = new TreeNode(node.val);
        result.left = buildTree(head, i);
        result.right = buildTree(node.next, size - i - 1);
        return result;
    }
}
