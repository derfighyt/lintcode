/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays
@Language: Java
@Datetime: 17-05-23 06:04
*/

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int [] result = new int [set2.size()];
        int i = 0;
        for (int num : set2) {
            result[i++] = num;
        }
        return result;
    }
}