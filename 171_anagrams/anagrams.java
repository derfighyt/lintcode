public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList();
        if (strs == null || strs.length < 2) {
            return result;
        }

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (str != null) {
                result.addAll(searchAnagrams(str, strs, i + 1));
            }
        }
        return result;
    }

    public List<String> searchAnagrams(String str, String[] strs, int from) {
        List<String> result = new ArrayList();
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[(int)(c - 'a')]++;
        }

        for (int i = from; i < strs.length; i++) {
            String s = strs[i];
            if (s == null) {
                continue;
            }
            if (str.length() != s.length()) {
                continue;
            }
            int[] map = new int[26];
            int j = 0;
            for (j = 0; j < s.length(); j++) {
                int n = (int)(s.charAt(j) - 'a');
                map[n]++;
                if (map[n] > count[n]) {
                    break;
                }
            }
            if (j == s.length()) {
                result.add(s);
                strs[i] = null;
            }
        }

        if (result.size() > 0) {
            result.add(0, str);
        }
        return result;
    }
}
