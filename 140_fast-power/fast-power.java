class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }
        long x = fastPower(a, b, n /2);
        x = (x * x) % b;
        if (n % 2 == 1) {
            x = (x * a) % b;
        }
//        while (n > 1) {
//            x = (x * x) % b;
//            n = n / 2;
//        }

        return (int)x;
    }
};

// 计算a^n % b，其中a，b和n都是32位的整数。
//
// 样例
// 例如 2^31 % 3 = 2
//
// 例如 100^1000 % 1000 = 0
