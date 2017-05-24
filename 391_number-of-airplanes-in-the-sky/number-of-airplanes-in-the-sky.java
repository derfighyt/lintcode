/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/number-of-airplanes-in-the-sky
@Language: Java
@Datetime: 17-05-24 03:18
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        int min = Integer.MAX_VALUE;
        int max = 0;
        HashMap<Integer, Integer> startMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> endMap = new HashMap<Integer, Integer>();

        for (Interval airplane : airplanes) {
            if (airplane.start < min) {
                min = airplane.start;
            }
            if (airplane.end > max) {
                max = airplane.end;
            }
            int val = startMap.get(airplane.start) == null ? 0 : startMap.get(airplane.start);
            startMap.put(airplane.start, val + 1);
            val = endMap.get(airplane.end) == null ? 0 : endMap.get(airplane.end);
            endMap.put(airplane.end, val + 1);
        }

        int count = 0;
        int maxplanes = 0;
        for (int i = min; i <= max; i++) {
            //对于每个时间点，优先降落
            int end = endMap.get(i) == null ? 0 : endMap.get(i);
            count -= end;
            int start = startMap.get(i) == null ? 0 : startMap.get(i);
            count += start;
            if (count > maxplanes) {
                maxplanes = count;
            }
        }
        return maxplanes;
    }
}
