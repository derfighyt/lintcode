public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m][n];
        int max = 0; //保存已经出现的最长公共子串长度
        for (int i = 0; i < m; i++) {
            //System.out.print(A.charAt(i));
            int length = 0; //保存当前字母结尾的公共字串长度
            for (int j = 0; j < n; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    length = (i == 0 || j == 0) ? 1 : dp[i - 1][j - 1] + 1;
                    max = Math.max(max, length);
                } else {
                    length = 0;
                }
                dp[i][j] = length;
                //System.out.print(" " + dp[i][j]);
            }
            //System.out.print("\n");
        }
        return max;
    }
}
// 给出两个字符串，找到最长公共子串，并返回其长度。
//
//  注意事项
//
// 子串的字符应该连续的出现在原字符串中，这与子序列有所不同。
//
// 样例
// 给出A=“ABCD”，B=“CBCE”，返回 2
//
// 挑战
// O(n x m) time and memory.
