class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null) {
            return -1;
        }
        int l1 = source.length();
        int l2 = target.length();
        if (l2 == 0) {
            return 0;
        }
        if (l1 == 0) {
            return -1;
        }
        int [] nextFunc = nextFunc(target);
        int index = 0;

        //"BBC ABCDAB ABCDABCDABDE", "ABCDABD"
        while (index <= l1 - l2) {
            int i = 0;
            for (i = 0; i < l2; i++) {
                if (source.charAt(index + i) != target.charAt(i)) {
                    break;
                }
            }
            if (i == l2) {
                return index;
            } else {
                if (nextFunc[i] == 0) {
                    index++;
                } else {
                    index = index + l2 - nextFunc[i] - 1;
                }
            }
        }
        return -1;
    }

    private int[] nextFunc(String target) {
        //"a  b  c  c  a  b  c  c  a  b  c  a"
        // 0  0  0  0  1  2  3  4  5  6  7
        int [] result = new int[target.length() + 1];
        result[0] = 0;
        result[1] = 0;
        int k = 0;
        for (int i = 1; i < target.length(); i++) {
            k = result[i];
            if (target.charAt(i) == target.charAt(k)) {
                result[i + 1] = k + 1;
            } else {
                while(k > 0 && target.charAt(k) != target.charAt(i)) {
                    k = result[k + 1];
                }
                if (target.charAt(k) == target.charAt(i)) {
                    result[i + 1] = result[k + 1];
                } else {
                    result[i + 1] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
