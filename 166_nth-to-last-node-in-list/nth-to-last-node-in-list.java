/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/nth-to-last-node-in-list
@Language: Java
@Datetime: 17-06-01 09:14
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
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return null;
        }
        int count = 1;
        ListNode node = head;

        while(node.next != null && count < n) {
            node = node.next;
            count++;
        }
        ListNode result = head;
        while (node.next != null) {
            node = node.next;
            result = result.next;
        }
        return result;
    }
}
