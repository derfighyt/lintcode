public class Solution {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = {-1, -1};
        if (A == null || A.length == 0) {
            return result;
        }
        int n = A.length;
        if (target < A[0] || target > A[n - 1]) {
            return result;
        }
        int start = 0, end = n - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (A[start] != target) {
            return result;
        }
        result[0] = start;
        start = result[0]; end = n - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        result[1] = A[start] == target ? start : start - 1;
        return result;
    }
}
