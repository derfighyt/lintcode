/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-list
@Language: Java
@Datetime: 17-06-01 09:32
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.next.val == node.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }  
}