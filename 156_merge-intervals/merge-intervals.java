/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/merge-intervals
@Language: Java
@Datetime: 17-05-25 08:22
*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> result = new ArrayList<Interval>();
        Interval i = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (Interval interval : intervals) {
            if (interval.start > i.end) {
                result.add(i);
                i = new Interval(interval.start, interval.end);
            } else {
                if (interval.end > i.end) {
                    i.end = interval.end;
                }
            }
        }
        result.add(i);
        return result;
    }

    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

}