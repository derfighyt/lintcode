/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/guess-number-game
@Language: Java
@Datetime: 17-06-02 05:35
*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        // Write your code here
        int s = 1;
        int e = n;
        while (s < e) {
            int x = (e - s) / 2 + s;
            if (guess(x) == 0) {
                return x;
            } else if (guess(x) < 0) {
                e = x - 1;
            } else {
                s = x + 1;
            }
        }
        return s;
    }
}