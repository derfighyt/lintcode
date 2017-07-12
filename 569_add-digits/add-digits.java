public class Solution {
    /**
     * @param num a non-negative integer
     * @return one digit
     */
    public int addDigits(int num) {
        // Write your code here
        if (num == 0) {
            return 0;
        } else if (num % 9 > 0){
            return num % 9;
        } else {
            return 9;
        }
    }
}
