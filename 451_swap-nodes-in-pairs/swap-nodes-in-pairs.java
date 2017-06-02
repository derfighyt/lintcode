/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/swap-nodes-in-pairs
@Language: Java
@Datetime: 17-06-01 09:58
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
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        while (node != null && node.next != null) {
            ListNode next = node.next;
            ListNode next2 = node.next.next;
            last.next = next;
            next.next = node;
            node.next = next2;
            last = node;
            node = next2;
        }
        return dummy.next;
    }
}