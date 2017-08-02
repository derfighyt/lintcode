public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        // Write your code here
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int positive = n > 0 ? 1 : 0;
        n = Math.abs(n);

        double result = helper(x, n);
        return positive > 0 ? result : 1 / result;
    }

    public double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double result = helper(x, n / 2);
        result = result * result;
        if (n % 2 == 1) {
            result *= x;
        }
        return result;
    }

}
// 实现 pow(x,n)
//
//  注意事项
//
// 不用担心精度，当答案和标准输出差绝对值小于1e-3时都算正确
//
// 样例
// Pow(2.1, 3) = 9.261
// Pow(0, 1) = 0
// Pow(1, 0) = 1
// 挑战
// O(logn) time
