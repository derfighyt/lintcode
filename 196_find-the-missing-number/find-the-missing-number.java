public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum1 += i + 1;
        }
        return sum1 - sum;
    }
}
