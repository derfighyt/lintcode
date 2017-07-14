public class Solution {
    /**
     * @param n an integer
     * @param str a string with number from 1-n
     *            in random order and miss one number
     * @return an integer
     */
    public int findMissing2(int n, String str) {
        // Write your code here
        int[] count = new int[31];
        int i = 0;
        while (i < str.length() - 1) {
            int num = Integer.parseInt(str.substring(i, i + 2));
            if (num > n || count[num] == 1) {
                num = Integer.parseInt(str.substring(i, i + 1));
            } else {
                i++;
            }
            i++;
            count[num]++;
        }
        if (i == str.length() - 1) {
            num = Integer.parseInt(str.substring(i, i + 1));
            count[num]++;
        }
        for (i = 1; i < 31; i++) {
            if (count[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}

// 给一个由 1 - n 的整数随机组成的一个字符串序列，其中丢失了一个整数，请找到它。
//  注意事项
// n <= 30
// 样例
// 给出 n = 20, str = 19201234567891011121314151618
// 丢失的数是 17 ，返回这个数。
