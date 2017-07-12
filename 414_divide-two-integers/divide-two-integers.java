public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        //http://blog.csdn.net/cdnight/article/details/11935387
        //http://billhoo.blog.51cto.com/2337751/411486/

        //KMP写的还是比较烂，后面需要优化一下
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }

        int n = divisor;
        int count = 1;
        while (n < dividend) {
            n = n << 1;
            count = count << 1;
        }

        while (n > dividend) {
            n -= divisor;
            count--;
        }
        return count;
    }
}
