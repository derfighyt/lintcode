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
    public ArrayList<Integer> intervalMinNumber(int[] A,
                                                ArrayList<Interval> queries) {
        // write your code here
        SegmentTreeNode root = buildTree(A, 0, A.length - 1);
        ArrayList<Integer> result = new ArrayList();
        for (Interval query : queries) {
            result.add(queryMin(root, query.start, query.end));
        }
        return result;
    }

    public int queryMin(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if (start == root.start && end == root.end) {
            return root.min;
        }
        int mid = (root.start + root.end) / 2;
        if (end <= mid) {
            return queryMin(root.left, start, end);
        } else if (start > mid) {
            return queryMin(root.right, start, end);
        }
        return Math.min(queryMin(root.left, start, mid), queryMin(root.right, mid + 1, end));
    }

    public SegmentTreeNode buildTree(int[] A, int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        int mid = (start + end) / 2;
        SegmentTreeNode left = buildTree(A, start, mid);
        SegmentTreeNode right = buildTree(A, mid + 1, end);
        SegmentTreeNode node = new SegmentTreeNode(start, end, Math.min(left.min, right.min));
        node.left = left;
        node.right = right;
        return node;
    }

    class SegmentTreeNode {
        public int start, end, min;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
            this.left = this.right = null;
        }
    }
}

// 给定一个整数数组（下标由 0 到 n-1，其中 n 表示数组的规模），以及一个查询列表。每一个查询列表有两个整数 [start, end]。
// 对于每个查询，计算出数组中从下标 start 到 end 之间的数的最小值，并返回在结果列表中。
//
//  注意事项
//
// 在做此题前，建议先完成以下三道题 线段树的构造， 线段树的查询 及 线段树的修改。
// 样例
// 对于数组 [1,2,7,8,5]， 查询 [(1,2),(0,4),(2,4)]，返回 [2,1,5]
//
// 挑战
// 每次查询在O(logN)的时间内完成
