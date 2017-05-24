/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/two-sum-input-array-is-sorted
@Language: Java
@Datetime: 17-05-22 05:44
*/

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        Map <Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        int [] result = new int [2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i + 1;
                return result;
            }
            map.put(target - nums[i], i + 1);
        }
        return result;
    }
}