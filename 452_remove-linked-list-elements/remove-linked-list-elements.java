/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/remove-linked-list-elements
@Language: Java
@Datetime: 17-06-01 06:11
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node.next != null) {
            ListNode next = node.next;
            if (next.val != val) {
                node = node.next;
            } else {
                node.next = next.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}