public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            if (!valid(s.charAt(i - 1), s.charAt(i))) {
                return 0;
            }
            if (s.charAt(i) == '0') {
                if (i == 1) {
                    result[i] = 1;
                } else {
                    result[i] = result[i - 2];
                }
            } else {
                result[i] = result[i - 1];
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                    if (i == 1) {
                        result[i]++;
                    } else {
                        result[i] += result[i - 2];
                    }
                }
            }
        }
        return result[n - 1];
    }

    public boolean valid(char c1, char c) {
        if ((c1 == '0' || c1 > '2') && c == '0') {
            return false;
        }
        return true;
    }
}
