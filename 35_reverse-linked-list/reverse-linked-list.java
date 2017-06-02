/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/reverse-linked-list
@Language: Java
@Datetime: 17-06-01 09:52
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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head.next;
        ListNode last = head;
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = last;
            last = node;
            node = next;
        }
        head.next = null;
        return last;
    }
}
