public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // Write your code here
        if (s == null) {
            s = "";
        }
        if (t == null) {
            t = "";
        }
        if (s.length() == t.length()) {//找到第一个不同字符
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
            }
            return false;
        }

        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        } else {
            if (s.length() < t.length()) {
                String tmp = s;
                s = t;
                t = tmp;
            }
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
            return true;
        }
    }
}
