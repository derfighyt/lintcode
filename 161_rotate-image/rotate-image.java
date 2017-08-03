public class Solution {
    /*
     * @param matrix: a lists of integers
     * @return:
     */

    public void rotate(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        Point[] point = new Point[4];
        int i = 0, j = 0;
        while (i < n / 2) {
            point[0] = new Point(i, j);
            point[1] = new Point(n-1-i, j);
            point[2] = new Point(n-1-i, n-1-j);
            point[3] = new Point(i, n-1-j);
            while (j < n - 1) {
                int tmp = matrix[point[0].x][point[0].y];
                for (int k = 0; k < 3; k++) {
                    matrix[point[k].x][point[k].y] = matrix[point[k+1].x][point[k+1].y];
                }
                matrix[point[3].x][point[3].y] = tmp;
                point[0].y++;
                point[1].x--;
                point[2].y--;
                point[3].x++;
                if (point[0].y == n-1-j) {
                    break;
                }
            }
            i++;
            j++;
        }
    }

    class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

};
// 给定一个N×N的二维矩阵表示图像，90度顺时针旋转图像。
//
// 样例
// 给出一个矩形[[1,2],[3,4]]，90度顺时针旋转后，返回[[3,1],[4,2]]
//
// 挑战
// 能否在原地完成？
