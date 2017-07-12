class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        int result = 0;
        int n1 = 1;
        int n2 = 0;
        for (int i = 3; i <= n; i++) {
            result = n1 + n2;
            n2 = n1;
            n1 = result;
        }

        return result;
    }
}
