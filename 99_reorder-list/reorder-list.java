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
     * @return: void
     */
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null) {
            return;
        }
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode node = head;
        if (node == tail || node.next == tail) {
            return;
        }
        tail.next = node.next;
        node.next = tail;

        while (true) {
            while (tail.next != node.next) {
                tail = tail.next;
            }
            node = node.next.next;
            if (node == tail || node.next == tail) {
                tail.next = null;
                break;
            }
            tail.next = node.next;
            node.next = tail;
        }
    }
}
// 给定一个单链表L: L0→L1→…→Ln-1→Ln,
//
// 重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…
//
// 必须在不改变节点值的情况下进行原地操作。
//
// 样例
// 给出链表 1->2->3->4->null，重新排列后为1->4->2->3->null。
//
// 挑战
// Can you do this in-place without altering the nodes' values?
