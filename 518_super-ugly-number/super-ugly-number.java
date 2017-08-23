public class Solution {
    /*
     * @param n: a positive integer
     * @param primes: the given prime list
     * @return: the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // write your code here
        int[] times = new int[primes.length];
        int[] uglys = new int[n];
        uglys[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * uglys[times[j]]);
            }
            uglys[i] = min;

            for (int j = 0; j < times.length; j++) {
                if (uglys[times[j]] * primes[j] == min) {
                    times[j]++;
                }
            }
        }
        return uglys[n - 1];

    }
}
// 写一个程序来找第 n 个超级丑数。
//
// 超级丑数的定义是正整数并且所有的质数因子都在所给定的一个大小为 k 的质数集合内。
//
// 比如给你 4 个质数的集合 [2, 7, 13, 19], 那么 [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] 是前 12 个超级丑数。
//
//  注意事项
//
// 1 永远都是超级丑数不管给的质数集合是什么。
// 给你的质数集合已经按照升序排列。
// 0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000
//
// 样例
// 给出 n = 6 和质数集合 [2, 7, 13, 19]。第 6 个超级丑数为 13，所以返回 13 作为结果。
