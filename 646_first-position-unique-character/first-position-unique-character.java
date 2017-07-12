public class Solution {
    /**
     * @param s a string
     * @return it's index
     */
    public int firstUniqChar(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] a = new int[s.length()];
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                a[map.get(c)] = 1;
                a[i] = 1;
            } else {
                map.put(c, i);
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
