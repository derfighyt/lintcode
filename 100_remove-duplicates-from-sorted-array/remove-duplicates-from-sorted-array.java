/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array
@Language: Java
@Datetime: 17-05-27 07:25
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int i = 0;
        int j = i + 1;
        int num = nums[i];
        int count = 1;
        while(i < nums.length) {
            while (j < nums.length) {
                if (nums[j] == num) {
                    j++;
                } else if (nums[j] > num) {
                    nums[++i] = nums[j++];
                    num = nums[i];
                    count++;
                    break;
                } else {
                    return count;
                }
            }
            if (j == nums.length) {
                i++;
                j = i + 1;
            }
        }
        return count;
    }
}