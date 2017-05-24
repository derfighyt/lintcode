/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/subarray-sum
@Language: Java
@Datetime: 17-05-22 09:40
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList <Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp == 0) {
                result.add(i);
                result.add(i);
                return result;
            }
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if (temp == 0) {
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        return result;
    }
}