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
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        if (A == null) {
            return null;
        }
        return helper(A, 0, A.length - 1);
    }

    public SegmentTreeNode helper(int[] A, int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        } else if (start > end) {
            return null;
        }

        SegmentTreeNode left = helper(A, start, (start + end) / 2);
        SegmentTreeNode right = helper(A, (start + end) / 2 + 1, end);
        SegmentTreeNode result = new SegmentTreeNode(start, end, Math.max(left.max, right.max));
        result.left = left;
        result.right = right;
        return result;
    }
}
