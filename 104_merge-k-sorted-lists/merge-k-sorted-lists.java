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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return helper(lists, 0, lists.size() - 1);
    }

    public ListNode helper(List<ListNode> lists, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return lists.get(start);
        } else if (start + 1 == end) {//两个，合并
            return merge(lists.get(start), lists.get(end));
        } else {
            return merge(helper(lists, start, (start + end) / 2),
                         helper(lists, (start + end) / 2 + 1, end));
        }
    }

    public ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        ListNode l = left;
        ListNode r = right;
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                index.next = l;
                l = l.next;
                index = index.next;
            } else {
                index.next = r;
                r = r.next;
                index = index.next;
            }
        }
        if (l != null) {
            index.next = l;
        }
        if (r != null) {
            index.next = r;
        }
        return dummy.next;
    }
}

// 合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。
//
// 样例
// 给出3个排序链表[2->4->null,null,-1->null]，返回 -1->2->4->null
