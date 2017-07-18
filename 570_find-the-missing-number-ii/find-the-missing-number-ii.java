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
        return helper(count, n, str);
    }

    public int helper(int[] count, int n, String str) {
        int result = 0;
        if (str == null || str.equals("")) {//计算结果，数组里必须只保留有1个0，否则就是非法的
            int zero = 0;
            for (int i = 1; i <= n; i++) {
                if (count[i] == 0) {
                    zero++;
                    result = i;
                }
            }
            if (zero == 1) {
                return result;
            } else {
                return 0;
            }
        }
        if (str.charAt(0) == 0) {//出现错误，需要回溯
            return 0;
        }
        //先取两位数字看看
        if (str.length() > 1) {
            int two = Integer.parseInt(str.substring(0, 2));
            if (two <= n && count[two] == 0) {//取前两位合法
                count[two] = 1;
                result = helper(count, n, str.substring(2));
                if (result != 0) {//已经得到正确结果
                    return result;
                }
                //无法得到正确结果，需要回溯
                count[two] = 0;
            }
        }

        //取两位不行，再取一位试试
        int one = Integer.parseInt(str.substring(0, 1));
        if (one <= n && count[one] == 0) {
            count[one] = 1;
            result = helper(count, n, str.substring(1));
            if (result != 0) {//已经得到正确结果
                return result;
            }
            //无法得到正确结果，需要回溯
            count[one] = 0;
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
// 特殊用例：n = 30, 1110986543271213130292826252423222120191817161514
// 可以拆分成27 也可以拆分成2 和 7，前者拆分虽然正确但会缺少两个数字，需要排除掉
