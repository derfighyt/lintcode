/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/partition-list
@Language: Java
@Datetime: 17-06-01 09:28
*/

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
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode left = leftHead;
        ListNode right = rightHead;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                left.next = node;
                left = left.next;
            } else {
                right.next = node;
                right = right.next;
            }
            node = node.next;
        }
        right.next = null;
        left.next = rightHead.next;
        return leftHead.next;
    }
}
