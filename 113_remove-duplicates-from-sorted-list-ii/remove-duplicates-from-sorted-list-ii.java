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
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }

        int count = 0;
        while (head != null && head.next != null && head.val == head.next.val) {
            head = head.next;
            count++;
        }
        if (count > 0) {
            head = head.next;
            head = deleteDuplicates(head);
        } else {
            head.next = deleteDuplicates(head.next);
        }

        return head;
    }
}
