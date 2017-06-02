/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/remove-nth-node-from-end-of-list
@Language: Java
@Datetime: 17-06-01 09:46
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
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return head;
        }
        int count = 1;
        ListNode node = head;

        while(node.next != null && count < n + 1) {
            node = node.next;
            count++;
        }

        ListNode result = head;
        if (node.next == null) {
            return head.next;
        }
        while (node.next != null) {
            node = node.next;
            result = result.next;
        }
        result.next = result.next.next;
        return head;
    }
}
