public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here

        int result = 0;
        int left = 0;
        int right = 0;
        int block = 0;
        int width = 0;
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            //左边界是left，右边界的位置应该是一个峰值
            if (width == 0) {
                //width = 0时，还在找左边界
                if (height >= left) {
                    left = height;
                } else {
                    //找到左边界
                    width++;
                    block += height;
                }
            } else if (width > 0) {
                //开始找右边界
                if (left <= right) {
                    //出现右边界
                    int tmp = Math.min(left, right) * (width-1) - block;
                    result += tmp;
                    left = right;
                    right = 0;
                    width = 1;
                    block = height;
                    max = 0;
                } else {
                    if (height < right) {
                        max = Math.max(max, right);
                    }
                    width++;
                    block += right;
                    right = height;
                }

            }
        }
        if (width > 0) {
            int tmp = Math.min(left, Math.max(max, right)) * (width-1) - block;
            if (tmp > 0) {
                result += tmp;
            }
        }

        return result;
    }
}
// Given n non-negative integers representing an elevation map where the width of each bar is 1,
//  compute how much water it is able to trap after raining.
//
// Trapping Rain Water
//
// 样例
// 如上图所示，海拔分别为 [0,1,0,2,1,0,1,3,2,1,2,1], 返回 6.
//
// 挑战
// O(n) 时间, O(1) 空间
//
// O(n) 时间, O(n) 空间也可以接受
