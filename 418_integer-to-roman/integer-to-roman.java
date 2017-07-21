public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
        //I（1）、V（5）、X（10）、L（50）、C（100）、D（500）、 M（1000）
        StringBuilder sb = new StringBuilder();
        if (n > 1000) {
            int times = n / 1000;
            while (times > 0) {
                sb.append("M");
            }
        }
        n = n % 1000;

        if (n >= 500) {
            sb.append("D");
            n = n - 500;
        }

        

        return sb.toString();
    }
}
// 给定一个整数，将其转换成罗马数字。
//
// 返回的结果要求在1-3999的范围内。
// 样例
// 4 -> IV
//
// 12 -> XII
//
// 21 -> XXI
//
// 99 -> XCIX
