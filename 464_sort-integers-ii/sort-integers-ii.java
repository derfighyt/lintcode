public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }

    public void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int m = A[(end + start) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            while (i <= j && A[i] < m) {
                i++;
            }
            while (i <= j && A[j] > m) {
                j--;
            }
            if (i <= j) {
                swap(A, i++, j--);
            }
        }
        quickSort(A, start, j);
        quickSort(A, i, end);
    }

    private void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}
