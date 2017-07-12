/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode node = head;
        int length = 1;
        while (node.next != null) {//找到链表尾
            node = node.next;
            length++;
        }
        node.next = head;//连成环
        k = k % length;

        while (k < length) {//移位
            head = head.next;
            node = node.next;
            k++;
        }
        node.next = null;
        return head;
    }
}
