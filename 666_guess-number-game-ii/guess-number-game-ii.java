public class Solution {
    /**
     * @param n an integer
     * @return how much money you need to have to guarantee a win
     */
    public int getMoneyAmount(int n) {
        // Write your code here
        //n = 1, r = 0
        //n = 2, r = 1   1
        //n = 3, r = 2   2
        //n = 4, r = 4   1 3
        //n = 5, r = 6   2 4
        //n = 6, r = 8   3 5
        //n = 7, r = 10  4 6
        //n = 8, r = 12  5 7
        //n = 9, r = 14  6 8
        //n = 10, r = 16 7 9
        //n = 11, r = 18 8 10
        //n = 12, r = 21 5 7 9
        // 目的：选出x个数，能把所有数字分开，且和最小
        //n是偶数时很明显，需要选取所有的奇数
        //n是奇数时，需要选所有的偶数？？
        int[] amount = new int[n + 1];
        amount[2] = 1;
        for (int i = 3; i <= n; i++) {
            int x = i - 1;
            int rightSum = x;
            int maxCost = Integer.MAX_VALUE;
            while (x > 0) {
                rightSum += x;
                int leftSum = amount[x - 1] + x;
                maxCost = Math.min(maxCost, Math.max(leftSum, rightSum));
                x -= 2;
            }
            amount[i] = maxCost;
        }
        return amount[n];
    }
}
// We are playing the Guess Game. The game is as follows:
// I pick a number from 1 to n. You have to guess which number I picked.
// Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
// However, when you guess a particular number x, and you guess wrong, you pay $x.
// You win the game when you guess the number I picked.
// 样例
// Given n = 10, I pick 8.
// First round: You guess 5, I tell you that it's higher. You pay $5.
// Second round: You guess 7, I tell you that it's higher. You pay $7.
// Third round: You guess 9, I tell you that it's lower. You pay $9.
//
// Game over. 8 is the number I picked.
// You end up paying $5 + $7 + $9 = $21.
//
// Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
// So when n = ｀10, return16`
