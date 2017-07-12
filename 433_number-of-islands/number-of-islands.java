public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        int count = 0;
        int linkCount = 0;
        if (grid == null) {
            return 0;
        }

        int m = grid.length;
        if (m == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid[0].length;

        Queue<Point> queue = new LinkedList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    count++;
                    queue.add(new Point(i, j));
                }
                while (!queue.isEmpty()) {
                    Point point = queue.poll();
                    grid[point.x][point.y] = false;
                    if (point.x > 0 && grid[point.x - 1][point.y]) {
                        queue.add(new Point(point.x - 1, point.y));
                    }
                    if (point.x < m - 1 && grid[point.x + 1][point.y]) {
                        queue.add(new Point(point.x + 1, point.y));
                    }
                    if (point.y > 0 && grid[point.x][point.y - 1]) {
                        queue.add(new Point(point.x, point.y - 1));
                    }
                    if (point.y < n - 1 && grid[point.x][point.y + 1]) {
                        queue.add(new Point(point.x, point.y + 1));
                    }
                }
            }
        }

        return count;
    }
}

class Point {
    public int x;
    public int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
