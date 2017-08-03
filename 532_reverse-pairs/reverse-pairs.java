public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // Write your code here
        return sort(A, 0, A.length - 1);
    }

    public long sort(int[] A, int start, int end) {
        long count = 0;
        if (start >= end) {
            return 0;
        }
        int[] result = new int[end - start + 1];
        int middle = (start + end) / 2;
        long left = sort(A, start, middle);
        long right = sort(A, middle + 1, end);
        count = count + left + right;
        int i = start, j = middle + 1;
        int index = 0;
        while (index < result.length) {
            if (i <= middle && j <= end) {
                if (A[i] <= A[j]) {
                    result[index++] = A[i++];
                } else {
                    result[index++] = A[j++];
                    count = count + (middle - i + 1);
                }
            } else if (i > middle) {
                result[index++] = A[j++];
            } else {
                result[index++] = A[i++];
            }
        }
        for (i = start; i <= end; i++) {
            A[i] = result[i - start];
        }
        return count;
    }
}
// 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。给你一个数组，求出这个数组中逆序对的总数。
// 概括：如果a[i] > a[j] 且 i < j， a[i] 和 a[j] 构成一个逆序对。
//
// 样例
// 序列 [2, 4, 1, 3, 5] 中，有 3 个逆序对 (2, 1), (4, 1), (4, 3)，则返回 3 。
