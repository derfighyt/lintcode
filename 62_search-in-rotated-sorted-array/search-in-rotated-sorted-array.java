public class Solution {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                if (A[start] < A[mid] ||A[start] > target) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if (A[end] > A[mid] || A[end] < target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        } else {
            return A[end] == target ? end : -1;
        }
    }
}
