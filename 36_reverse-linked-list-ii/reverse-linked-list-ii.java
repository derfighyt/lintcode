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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        ListNode node1 = head;
        ListNode node2 = head;
        int count = 1;
        while (count < n) {
            if (count < m - 1) {
                node1 = node1.next;
            }
            node2 = node2.next;
            count++;
        }

        ListNode next = node2.next;
        node2.next = null;
        if (m == 1) {
            ListNode tail = node1;
            head = reverse(node1);
            tail.next = next;
        } else {
            ListNode tail = node1.next;
            node1.next = reverse(node1.next);
            tail.next = next;
        }
        return head;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        ListNode node = last.next;
        while (node != null) {
            ListNode next = node.next;
            node.next = last;
            last = node;
            node = next;
        }
        head.next = null;
        return last;
    }
}

// 翻转链表中第m个节点到第n个节点的部分
//
//  注意事项
//
// m，n满足1 ≤ m ≤ n ≤ 链表长度
//
// 样例
// 给出链表1->2->3->4->5->null， m = 2 和n = 4，返回1->4->3->2->5->null
//
// 挑战
// 在原地一次翻转完成
