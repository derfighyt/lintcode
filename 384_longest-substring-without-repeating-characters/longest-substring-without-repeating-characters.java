public class Solution {
    /*
     * @param : a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        //int[] bitmap = new int[256];
        Map<Character, Integer> map = new HashMap(); //记录每个字母出现的位置
        int length = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= i - length) {//出现重复字符
                length = i - map.get(c);
            } else {
                length++;
            }
            max = Math.max(length, max);
            map.put(c, i);
        }
        return max;
    }
};
// 给定一个字符串，请找出其中无重复字符的最长子字符串。
//
// 样例
// 例如，在"abcabcbb"中，其无重复字符的最长子字符串是"abc"，其长度为 3。
//
// 对于，"bbbbb"，其无重复字符的最长子字符串为"b"，长度为1。
//
// 挑战
// O(n) 时间
