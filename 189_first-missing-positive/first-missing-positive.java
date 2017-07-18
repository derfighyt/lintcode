public class Solution {
    /**
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        //思路：把i交换到i-1的位置
        if (A == null || A.length == 0) {
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                //把A[i] 和 A[A[i] - 1]交换，但是要注意重复元素和死循环，注意边界
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}

// 给出一个无序的正数数组，找出其中没有出现的最小正整数。
//
// 样例
// 如果给出 [1,2,0], return 3
// 如果给出 [3,4,-1,1], return 2
