/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root == null || start > root.end || end < root.start) {
            return 0;
        }
        if (root.start == root.end) {
            return root.count;
        }

        int p = (root.start + root.end) / 2;
        if (end <= p) {
            return query(root.left, start, end);
        } else if (start > p) {
            return query(root.right, start, end);
        } else {
            return query(root.left, start, p) + query(root.right, p + 1, end);
        }
    }
}
