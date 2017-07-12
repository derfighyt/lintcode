public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null) {
            return 0;
        }
        int cur = 0;
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            int now = nums[i];
            while (j < nums.length) {
                if (nums[j] > now) {
                    break;
                }
                if (j - i < 2) {
                    nums[cur++] = nums[j++];
                } else {
                    j++;
                }
            }
            i = j;
        }
        return cur;
    }
}
