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
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        int n = 0;
        ListNode node = head;
        while(node != null) {
            n++;
            node = node.next;
        }
        if (n == 0) {
            return true;
        }
        ListNode middle = middle(head);
        ListNode rightHead = middle.next;
        middle.next = null; //从中间节点断开
        ListNode leftHead = reverse(head); //将左半翻转, leftHead就等于middle
        if (n % 2 == 1) {
            leftHead = leftHead.next;
        }
        while(leftHead != null && rightHead != null) {
            if (leftHead.val != rightHead.val) {
                return false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        if (leftHead == null && rightHead == null) {
            return true;
        }
        return false;
    }

    public ListNode middle(ListNode head) {//找到链表的中点位置
        if (head == null || head.next == null) {
            return head;
        }
        int count = 2;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            count += 2;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode node3 = head.next.next;
        head.next = null;
        //翻转前两个节点的指针，并记录第三个节点
        while (node2 != null) {
            node2.next = node1;
            node1 = node2;
            node2 = node3;
            if (node3 != null) {
                node3 = node3.next;
            }
        }
        return node1;
    }
}
// 设计一种方式检查一个链表是否为回文链表。
//
// 样例
// 1->2->1 就是一个回文链表。
//
// 挑战
// O(n)的时间和O(1)的额外空间。
