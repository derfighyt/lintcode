public class Solution {
    /*
     * @param : A string
     * @param : A string
     * @param : A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //s1的前i个和s2的前j个能不能组成s3的前i+j个
                dp[i][j] = (dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ||
                            (dp[i-1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[m][n];
    }
};

// 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
// 样例
// 比如 s1 = "aabcc" s2 = "dbbca"
//
//     - 当 s3 = "aadbbcbcac"，返回  true.
//     - 当 s3 = "aadbbbaccc"， 返回 false.
//
// 挑战
// 要求时间复杂度为O(n^2)或者更好
