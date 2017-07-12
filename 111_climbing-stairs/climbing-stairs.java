public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        // write your code here
        //从n-1到n，有1种
        //从n-2到n，有2种
        //r[n] = r[n - 1] + r[n - 2]
        //r[0] = ``, r[1] = 1
        //r[2] = 1,1 | 2
        //r[3] = 1,1,1 | 1,2 | 2,1
        //r[4] = 1,1,1,1 | 1,1,2 | 1,2,1 | 2,1,1 | 2,2 = 5
        //r[5] = 1,1,1,1,1 | 1,1,2,1 | 1,2,1,1 | 2,1,1,1 | 2,2,1 | 1,1,1,2 | 1,2,2 | 2,1,2 = 8
        if (n <= 1) {
            return 1;
        }
        int result = 0;
        int n1 = 1;
        int n2 = 1;
        for (int i = 2; i <= n; i++) {
            result = n1 + n2;
            n2 = n1;
            n1 = result;
        }
        return result;
    }
}
