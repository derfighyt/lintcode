public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int count = 0;
        int n = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                n = nums.get(i);
                count++;
            } else if (nums.get(i) == n) {
                count++;
            } else {
                count--;
            }
        }
        return n;
    }
}
