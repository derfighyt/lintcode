public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }
        int m = A.length();
        int n = B.length();
        int[][] result = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    result[i][j] = Math.max(result[i - 1][j - 1] + 1, Math.max(result[i - 1][j], result[i][j - 1]));
                } else {
                    result[i][j] = Math.max(result[i - 1][j - 1], Math.max(result[i - 1][j], result[i][j - 1]));
                }
            }
        }
        return result[m][n];
    }
}
