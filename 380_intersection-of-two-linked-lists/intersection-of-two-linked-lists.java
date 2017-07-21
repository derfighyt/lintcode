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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tail = headA;
        while (tail.next != null) {//找到A的尾部，
            tail = tail.next;
        }
        tail.next = headB;
        ListNode result = cycle(headA);
        tail.next = null;
        return result;
    }

    public ListNode cycle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //这里是能推导出一个公式的，即相遇点距离交叉点(环的起点)的距离是和环外面的尾巴相关的，所以可以这么搞
        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
// 请写一个程序，找到两个单链表最开始的交叉节点。
//
//  注意事项
//
// 如果两个链表没有交叉，返回null。
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 样例
// 下列两个链表：
//
// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗
// B:     b1 → b2 → b3
// 在节点 c1 开始交叉。
//
// 挑战
// 需满足 O(n) 时间复杂度，且仅用 O(1) 内存。
