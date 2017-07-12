public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        long[] factorial = new long[A.length];
        factorial[0] = 1;
        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = factorial[i - 1] * (i + 1);
        }
        long count = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if (A[j] < A[i]) {
                    count += factorial[A.length - i - 2];
                }
            }
        }
        return count;
    }
}
