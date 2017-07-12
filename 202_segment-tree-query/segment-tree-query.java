/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root == null) {
            return 0;
        }
        if (root.start == root.end) {
            return root.max;
        }
        int p = (root.start + root.end) / 2;
        int max = 0;
        if (end <= p) {
            max = query(root.left, start, end);
        } else if (start > p) {
            max = query(root.right, start, end);
        } else {
            max = Math.max(query(root.left, start, p),
            query(root.right, p + 1, end));
        }
        return max;
    }
}
