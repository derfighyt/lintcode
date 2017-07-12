public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        long result = 0;
        boolean flag = false;
        if (n < 0) {
            n = 0 - n;
            flag = true;
        }
        while (n > 0) {
            int tmp = n % 10;
            result  = result * 10 + tmp;
            n = n / 10;
        }
        if (flag) {
            result = 0 - result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result;
    }
}
