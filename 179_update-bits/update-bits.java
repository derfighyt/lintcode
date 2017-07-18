class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int ones = ~0;  //将所有的位置为1
        int mask;
        if (j < 31) {
            mask = ones << (j+1);   //将0到j位都置为0
            mask |= ((1<<i) - 1);    //将i到j位置为0，其余位为1;
        } else {
            mask = ((1<<i) - 1);    //此时j = 32;
        }

        return (n & mask) | (m<<i) ;
    }
}
// 给出两个32位的整数N和M，以及两个二进制位的位置i和j。写一个方法来使得N中的第i到j位等于M（M会是N中从第i为开始到第j位的子串）
//
//  注意事项
//
// In the function, the numbers N and M will given in decimal, you should also return a decimal number.
// 说明
// You can assume that the bits j through i have enough space to fit all of M.
// That is, if M=10011， you can assume that there are at least 5 bits between j and i.
// You would not, for example, have j=3 and i=2, because M could not fully fit between bit 3 and bit 2.
//
// 样例
// 给出N = (10000000000)2，M = (10101)2， i = 2, j = 6
//
// 返回 N = (10001010100)2
