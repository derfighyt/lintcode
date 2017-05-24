/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays-ii
@Language: Java
@Datetime: 17-05-23 06:33
*/

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            map1.put(num, map1.get(num) == null ? 1 : map1.get(num) + 1);
        }
        for (int num : nums2) {
            if (map1.containsKey(num)) {
                map2.put(num, map2.get(num) == null ? 1 : map2.get(num) + 1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int num : map2.keySet()) {
            for (int i = 0; i < map1.get(num) && i < map2.get(num); i++) {
                list.add(num);
            }
        }
        int [] result = new int[list.size()];
        int i = 0;
        for (int num : list) {
            result[i++] = num;
        }
        return result;
    }
}