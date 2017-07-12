public class Solution {
    /**
     * @param s a string
     * @param p a non-empty string
     * @return a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // Write your code here
        if (p == null || s == null) {
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[(int)(p.charAt(i) - 'a')]++;
        }

        int i = 0;
        while (i <= s.length() - p.length()) {
            int[] test = new int[26];
            int j = i;
            while (j - i < p.length()) {
                int index = (int)(s.charAt(j) - 'a');
                test[index]++;
                //判断
                if (test[index] > map[index]) {
                    //超出范围，
                    break;
                } else if (j - i == p.length() - 1){
                    //找到
                    result.add(i);
                    break;
                } else {
                    j++;
                }
            }
            i++;
        }
        return result;
    }
}
