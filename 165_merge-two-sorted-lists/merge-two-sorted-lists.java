/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-lists
@Language: Java
@Datetime: 17-06-01 09:07
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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode node1 = l1;
        while (node1 != null) {
            l2 = insertNode(l2, node1);
            node1 = node1.next;
        }
        return l2;
    }

    private ListNode insertNode(ListNode head, ListNode node) {
        ListNode n = new ListNode(node.val);
        if (n.val <= head.val) {
            n.next = head;
            return n;
        }
        ListNode point = head;
        while (point.next != null && point.next.val < n.val) {
            point = point.next;
        }
        n.next = point.next;
        point.next = n;
        return head;
    }
}