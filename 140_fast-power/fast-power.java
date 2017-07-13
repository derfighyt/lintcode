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
        long x = fastPower(a, b, n /2);//先算出低一级的余，如5次方先算出2次方的余
        x = (x * x) % b;//2次 x 2次 = 4次方的余
        if (n % 2 == 1) { //如果是奇数次再乘一次。
            x = (x * a) % b;
        }
        return (int)x;
    }
};

// 计算a^n % b，其中a，b和n都是32位的整数。
//
// 样例
// 例如 2^31 % 3 = 2
//
// 例如 100^1000 % 1000 = 0
