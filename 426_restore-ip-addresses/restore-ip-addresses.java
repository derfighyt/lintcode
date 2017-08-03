public class Solution {
    ArrayList<String> result = new ArrayList();
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        helper(s, 0, 0, "");
        return result;
    }

    public void helper(String s, int i, int count, String ip) {
        if (i == s.length()) {
            if (count == 4) {
                result.add(ip.substring(1));
            }
            return;
        }
        int start = i, end = i + 3;
        while (end > s.length()) {
            end--;
        }

        while (start < end) {
            String str = s.substring(start, end);
            if (str.length() == 1 || !('0' == str.charAt(0))) {
                int num = Integer.parseInt(str);
                if (num >= 0 && num < 256) {
                    helper(s, end, count + 1, ip + "." + str);
                }
            }
            end--;
        }
    }
}
// 给一个由数字组成的字符串。求出其可能恢复为的所有IP地址。
//
// 样例
// 给出字符串 "25525511135"，所有可能的IP地址为：
//
// [
//   "255.255.11.135",
//   "255.255.111.35"
// ]
// （顺序无关紧要）
