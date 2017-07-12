public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        if (divisor == 0) {
            return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) ||
                             (dividend > 0 && divisor < 0);

        long a = Math.abs((long)dividend); //转成long避免
        long b = Math.abs((long)divisor);
        int result = 0;
        while(a >= b){
            int shift = 0;
            while(a >= (b << shift)){//计算除数左移多少位能大于被除数
                shift++;
            }
            a -= b << (shift - 1);//被除数减去最大的左移位数
            result += 1 << (shift - 1);
        }
        //本质上是计算结果里有多少个1，比如11 = 8 + 2 + 1
        return isNegative? -result: result;

    }
}
