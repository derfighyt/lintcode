/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/majority-number-iii
@Language: Java
@Datetime: 17-05-23 08:59
*/

public class Solution {
    /*
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code here
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.get(num)== null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > (nums.size()/k)) {
                return num;
            }
        }
        return 0;
    }
};