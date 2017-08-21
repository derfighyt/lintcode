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
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        int mid = head.val;//head节点直接作为中值
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode middle = new ListNode(0);

        ListNode l = left;
        ListNode r = right;
        ListNode m = middle;
        ListNode node = head;
        while (node != null) {
            if (node.val < mid) {
                l.next = node;
                node = node.next;
                l = l.next;
                l.next = null;
            } else if (node.val > mid) {
                r.next = node;
                node = node.next;
                r = r.next;
                r.next = null;
            } else {
                m.next = node;
                node = node.next;
                m = m.next;
                m.next = null;
            }
        }

        ListNode x = sortList(left.next);
        ListNode y = sortList(right.next);
        if (x != null) {
            ListNode z = x;
            while (z.next != null) {
                z = z.next;
            }
            z.next = middle.next;
            m.next = y;
            return x;
        } else {
            m.next = y;
            return middle.next;
        }
    }
}
// 在 O(n log n) 时间复杂度和常数级的空间复杂度下给链表排序。
//
// 样例
// 给出 1->3->2->null，给它排序变成 1->2->3->null.
//
// 挑战
// 分别用归并排序和快速排序做一遍。
