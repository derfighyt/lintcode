class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int peak = 0;
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                peak = i;
                max = A[i];
            } else {
                break;
            }
        }

        if (peak > 0 && peak < A.length - 1) {
            return peak;
        } else {
            return -1;
        }
    }
}
