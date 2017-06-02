/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/add-two-numbers
@Language: Java
@Datetime: 17-06-01 06:26
*/

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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode result = new ListNode(0);
        ListNode head = result;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int sum = flag;
            sum += (l1 == null ? 0 : l1.val);
            sum += (l2 == null ? 0 : l2.val);
            result.next = new ListNode(sum % 10);
            result = result.next;
            flag = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (flag > 0) {
            result.next = new ListNode(1);
        }
        return head.next;
    }
}