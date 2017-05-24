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
        int [] startArray = new int [airplanes.size()];
        int [] endArray = new int [airplanes.size()];
        for (int i = 0; i < airplanes.size(); i++) {
            startArray[i] = airplanes.get(i).start;
            endArray[i] = airplanes.get(i).end;
        }
        Arrays.sort(startArray);
        Arrays.sort(endArray);
        int count = 0;
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < airplanes.size()) {
            if (startArray[i] < endArray[j]) {
                count++;
                i++;
            } else if (startArray[i] == endArray[j]) {
                i++;
                j++;
            } else {
                count--;
                j++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
