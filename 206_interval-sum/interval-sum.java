/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A,
                                       ArrayList<Interval> queries) {
        // write your code here
        SegmentTreeNode root = buildTree(A, 0, A.length - 1);
        ArrayList<Long> result = new ArrayList();
        for (Interval query : queries) {
            result.add(querySum(root, query.start, query.end));
        }
        return result;
    }

    public long querySum(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if (start == root.start && end == root.end) {
            return root.sum;
        }
        int mid = (root.start + root.end) / 2;
        if (end <= mid) {
            return querySum(root.left, start, end);
        } else if (start > mid) {
            return querySum(root.right, start, end);
        }
        return querySum(root.left, start, mid) + querySum(root.right, mid + 1, end);
    }

    public SegmentTreeNode buildTree(int[] A, int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        int mid = (start + end) / 2;
        SegmentTreeNode left = buildTree(A, start, mid);
        SegmentTreeNode right = buildTree(A, mid + 1, end);
        SegmentTreeNode node = new SegmentTreeNode(start, end, left.sum + right.sum);
        node.left = left;
        node.right = right;
        return node;
    }

    class SegmentTreeNode {
        public int start, end;
        public long sum;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, long sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }
    }
}
// 给定一个整数数组（下标由 0 到 n-1，其中 n 表示数组的规模），以及一个查询列表。每一个查询列表有两个整数 [start, end] 。
// 对于每个查询，计算出数组中从下标 start 到 end 之间的数的总和，并返回在结果列表中。
//
//  注意事项
//
// 在做此题前，建议先完成以下三题：线段树的构造， 线段树的查询，以及线段树的修改。
//
// 样例
// 对于数组 [1,2,7,8,5]，查询[(1,2),(0,4),(2,4)], 返回 [9,23,20]
//
// 挑战
// O(logN) time for each query
