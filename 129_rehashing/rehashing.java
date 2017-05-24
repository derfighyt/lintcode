/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/rehashing
@Language: Java
@Datetime: 17-05-23 08:14
*/

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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int size = hashTable.length * 2;
        ListNode[] result = new ListNode[size];
        for (int i = 0; i < hashTable.length; i++) {
            ListNode node = hashTable[i];
            while(node != null) {
                int index = 0;
                int val = node.val;
                if (val < 0) {
                    index = (val % size + size) % size;
                } else {
                    index = val % size;
                }
                ListNode newNode = new ListNode(val);
                if (result[index] == null) {
                    result[index] = newNode;
                } else {
                    ListNode position = result[index];
                    while (position.next != null) {
                        position = position.next;
                    }
                    position.next = newNode;
                }
                node = node.next;
            }
        }
        return result;
    }
    
};
