/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param head: a ListNode
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode[] nodes = findNode(dummy, v1, v2);

        ListNode a = nodes[0];
        ListNode b = nodes[1];
        if (a == null || b == null) {
            return head;
        }

        if (a.next == b) {
            a.next = b.next;
            b.next = b.next.next;
            a.next.next = b;
        } else {
            ListNode a1 = a.next;
            a.next = b.next;
            b.next = b.next.next;
            a.next.next = a1.next;
            a1.next = b.next;
            b.next = a1;
        }
        return dummy.next;
    }

    public ListNode[] findNode(ListNode head, int v1, int v2) {
        //返回val等于v的节点的上一个节点
        ListNode node = head;
        ListNode [] result = new ListNode[2];
        int index = 0;
        while (node.next != null) {
            if (node.next.val == v1 || node.next.val == v2) {
                result[index++] = node;
            }
            node = node.next;
        }
        return result;
    }
}
// 给你一个链表以及两个权值v1和v2，交换链表中权值为v1和v2的这两个节点。
// 保证链表中节点权值各不相同，如果没有找到对应节点，那么什么也不用做。
//
//  注意事项
//
// 你需要交换两个节点而不是改变节点的权值
//
// 样例
// 给出链表 1->2->3->4->null ，以及 v1 = 2 ， v2 = 4
// 返回结果 1->4->3->2->null。
