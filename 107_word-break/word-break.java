public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true; //空串
        for (int i = 1; i <= s.length(); i++) {
            result[i] = false;
            for (int j = 1; j <= maxLength && j <= i; j++) {//从当前位置往前找maxLength个字母，判断这些是否能组成词，超过了就不用再找了
                if (!result[i - j]) {//如果
                    continue;
                }
                String word = s.substring(i - j, i);
                if (dict.contains(word)) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }
}
