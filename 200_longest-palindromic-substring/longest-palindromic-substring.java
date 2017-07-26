public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() <= 1) {
            return s;
        }
        int n = s.length();
        int[] dp = new int[n];//记录回文串长度
        dp[0] = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = i;
            if (dp[i - 1] < i - 1 && dp[i - 1] > 0 && s.charAt(dp[i - 1] - 1) == s.charAt(i)) {//能构成更长的回文
                dp[i] = dp[i - 1] - 1;
            } else if (s.charAt(i) == s.charAt(i - 1)) {//判断和前一个字符串相同的特殊情况
                int j = i - 1;
                while (j >= 0 &&s.charAt(i) == s.charAt(j)) {
                    j--;
                }
                dp[i] = j + 1;
            } else if (i > 1 && s.charAt(i) == s.charAt(i - 2)) {//和前两个字符能组成三连回文
                dp[i] = i - 2;
            }

            if (i + 1 - dp[i] > max) {
                max = i + 1 - dp[i];
                start = dp[i];
                end = i + 1;
            }
        }
        return s.substring(start, end);
    }
}
// 给出一个字符串（假设长度最长为1000），求出它的最长回文子串，你可以假定只有一个满足条件的最长回文串。
//
// 样例
// 给出字符串 "abcdzdcab"，它的最长回文子串为 "cdzdc"。
//
// 挑战
// O(n2) 时间复杂度的算法是可以接受的，如果你能用 O(n) 的算法那自然更好。
