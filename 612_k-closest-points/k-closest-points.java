/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        final int x = origin.x;
        final int y = origin.y;
        PriorityQueue<Point> heap = new PriorityQueue<Point>(k, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                long dis1 = power(o1.x - x) + power(o1.y - y);
                long dis2 = power(o2.x - x) + power(o2.y - y);
                if (dis1 < dis2) {
                    return -1;
                } else if (dis1 > dis2) {
                    return 1;
                } else {
                    if (o1.x != o2.x) {
                        return o1.x - o2.x;
                    } else {
                        return o1.y - o2.y;
                    }
                }
            }

            public boolean equals(Object obj) {
                return false;
            }
        });

        for (Point point : points) {
            heap.add(point);
        }
        Point[] result = new Point[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

    public long power(int x) {
        return x * x;
    }
}
