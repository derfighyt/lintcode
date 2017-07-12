/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        copyList(head);
        copyRandom(head);
        return split(head);
    }

    public void copyList(RandomListNode head) {
        //第一步先复制原链表每个节点并插入原链表中，，且random指向相同节点
        //1 -> 1' -> 2 -> 2' -> 3 -> 3'
        // \  /       \  /       \  /
        //  r1 -> r1'  r2 -> r2'  r3 -> r3'
        RandomListNode node = head;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            newNode.random = node.random;
            node.next = newNode;
            node = newNode.next;
        }
    }

    public void copyRandom(RandomListNode head) {
        //第二步对每个新节点，修改其random节点指向新节点
        //1 -> 1' -> 2 -> 2' -> 3 -> 3'
        // \    \     \    \     \    \
        //  r1 -> r1'  r2 -> r2'  r3 -> r3'
        RandomListNode node = head.next;
        while (node != null) {
            if (node.random != null) {
                node.random = node.random.next;//random节点的next就是其复制节点
            }
            if (node.next != null) {
                node = node.next.next;
            } else {
                node = null;
            }
        }
    }

    public RandomListNode split(RandomListNode head) {
        //第三步抽出新链表并返回
        //1 -> 1' -> 2 -> 2' -> 3 -> 3'
        // \    \     \    \     \    \
        //  r1 -> r1'  r2 -> r2'  r3 -> r3'
        RandomListNode newHead = head.next;
        RandomListNode newNode = newHead;
        while (newNode != null) {
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
            }
            newNode = newNode.next;
        }
        return newHead;
    }
}
