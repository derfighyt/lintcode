class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int num = i;
            while (num > 0) {
                if (num % 10 == k) {
                    count++;
                }
                num = num / 10;
            }
        }
        if (k == 0) {
            count++;
        }
        return count;
    }
};
