class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        //a1xb1 + a2xb2 + ... + anxbn
        //a12 + a22 + ... + An2
        //b12 + b22 + ... + bn2
        if (A == null || A.length == 0) {
            return 2;
        }
        if (sqrt2(A) == 0) {
            return 2;
        }
        int a = 0;
        for (int i = 0; i < A.length; i++) {
            a += (A[i] * B[i]);
        }

        return a / (sqrt2(A) * sqrt2(B));

    }

    public double sqrt2(int [] array) {
        int result = 0;
        for (int i : array) {
            result += (i * i);
        }
        return Math.sqrt(result);
    }
}
