public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null) {
            return "";
        }
        String result = "";
        for (String str : strs) {
            if (str.equals("")) {
                return "";
            } else if (result.equals("")) {
                result = str;
            } else {
                for (int i = 0; i < result.length() && i < str.length(); i++) {
                    if (result.charAt(i) != str.charAt(i)) {
                        result = result.substring(0, i);
                    }
                }
            }
        }
        return result;
    }
}
// 给k个字符串，求出他们的最长公共前缀(LCP)
// 样例
// 在 "ABCD" "ABEF" 和 "ACEF" 中,  LCP 为 "A"
// 在 "ABCDEFG", "ABCEFG", "ABCEFA" 中, LCP 为 "ABC"
