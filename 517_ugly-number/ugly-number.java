public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        // Write your code here
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0) {
            return false;
        }

        if (num % 2 == 0) {
            num = num / 2;
        }
        if (num % 3 == 0) {
            num = num / 3;
        }
        if (num % 5 == 0) {
            num = num / 5;
        }

        return isUgly(num);
    }
}
