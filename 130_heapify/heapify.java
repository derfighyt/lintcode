public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        int n = A.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(A, i);
        }
    }

    public void shiftUp(int[] A, int x) {
        //
    }

    public void shiftDown(int[] A, int x) {
        int n = A.length;
        int y = x * 2 + 1;
        while (y < n) {
            if (y + 1 < n && A[y + 1] < A[y]) { //判断右子节点是否更小
                y++;
            }
            if (A[y] < A[x]) {//需要交换
                swap(A, x, y);
                x = y;
                y = x * 2 + 1;
            } else {
                break;
            }
        }
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
// 给出一个整数数组，堆化操作就是把它变成一个最小堆数组。
//
// 对于堆数组A，A[0]是堆的根，并对于每个A[i]，A [i * 2 + 1]是A[i]的左儿子并且A[i * 2 + 2]是A[i]的右儿子。
// 说明
// 什么是堆？
//
// 堆是一种数据结构，它通常有三种方法：push， pop 和 top。其中，“push”添加新的元素进入堆，“pop”删除堆中最小/最大元素，“top”返回堆中最小/最大元素。
// 什么是堆化？
//
// 把一个无序整数数组变成一个堆数组。如果是最小堆，每个元素A[i]，我们将得到A[i * 2 + 1] >= A[i]和A[i * 2 + 2] >= A[i]
// 如果有很多种堆化的结果？
//
// 返回其中任何一个。
// 样例
// 给出 [3,2,1,4,5]，返回[1,2,3,4,5] 或者任何一个合法的堆数组
//
// 挑战
// O(n)的时间复杂度完成堆化
