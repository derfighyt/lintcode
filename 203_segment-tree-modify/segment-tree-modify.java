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
     *@param root, index, value: The root of segment tree and
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (root == null) {
            return;
        }
        if (index < root.start || index > root.end) {
            return;
        }
        if (root.start == root.end) {
            if (root.start == index) {
                root.max = value;
            }
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (index <= mid) {
            modify(root.left, index, value);
            root.max = root.right == null ? root.left.max : Math.max(root.right.max, root.left.max);
        } else {
            modify(root.right, index, value);
            root.max = root.left == null ? root.right.max : Math.max(root.left.max, root.right.max);
        }
    }
}
