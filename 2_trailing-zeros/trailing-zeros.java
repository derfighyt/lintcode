class Solution {
    /*
     * param n: An desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        long count = 0;

        while (n > 5) {
            count = count + (n / 5);
            n = n / 5;
        }
        return count;
    }

};
