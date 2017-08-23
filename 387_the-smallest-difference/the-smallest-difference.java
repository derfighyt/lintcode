public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        int m = A.length;
        int n = B.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < m && j < n) {
            min = Math.min(min, Math.abs(A[i] - B[j]));
            if (min == 0) {
                return 0;
            }
            if (A[i] > B[j]) {
                j++;
            } else {
                i++;
            }
        }
        return min;
    }
}
// 给定两个整数数组（第一个是数组 A，第二个是数组 B），在数组 A 中取 A[i]，数组 B 中取 B[j]，
// A[i] 和 B[j]两者的差越小越好(|A[i] - B[j]|)。返回最小差。
//
// 样例
// 给定数组 A = [3,4,6,7]， B = [2,3,8,9]，返回 0。
//
// 挑战
// 时间复杂度 O(n log n)
