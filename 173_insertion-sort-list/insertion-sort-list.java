/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/insertion-sort-list
@Language: Java
@Datetime: 17-06-01 08:48
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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        
        while (cur != null) {
            if (cur.next != null && cur.next.val < cur.val) {
                ListNode node = cur.next;
                cur.next = node.next;
                head = insertNode(head, node);
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    private ListNode insertNode(ListNode head, ListNode node) {
        if (head == null) {
            return node;
        }
        if (node == null) {
            return head;
        }
        if (node.val <= head.val) {
            node.next = head;
            return node;
        }
        ListNode point = head;
        while (point.next != null && point.next.val < node.val) {
            point = point.next;
        }
        node.next = point.next;
        point.next = node;
        return head;
    }
}