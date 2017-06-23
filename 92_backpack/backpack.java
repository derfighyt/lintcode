/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/backpack
@Language: Java
@Datetime: 17-06-23 15:19
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (m <= 0 || A == null || A.length == 0) {
            return 0;
        }
        int max = 0;
        int n = A.length;
        int[][] sum = new int[n][m]; //1 - m 容量的背包
        //扫描A,对每个物品，求出对应每个容量的最优解。
        for (int j = 0; j < m; j++) {
            sum[0][j] = A[0] <= j + 1 ? A[0] : 0;
        }
        for (int i = 1; i < A.length; i++) {
            //第一个物品A[0], 第n个物品A[n-1]
            for (int j = 0; j < m; j++) {
                //j=0 为容量1, j=m-1为容量m
                if (A[i] > j + 1) {
                    //当前容量装不下这个物品，则最优解为i-1个物品时的最优解
                    sum[i][j] = sum[i - 1][j]; //不变
                } else if (A[i] == j + 1) {
                    //当前容量等于这个物品，最优解即为当前容量/物品重量
                    sum[i][j] = A[i];
                } else {
                    //当前容量超过这个物品，最优解存在两种情况，即这个物品装或不装,取最大值
                    //1. 如果装，则最优解为这个物品重量，加上剩余容量的最优解，但剩余容量的最优解可能已被覆盖
                    //2. 如果不装，则最优解为i-1个物品时的最优解，即原值。
                    sum[i][j] = Math.max(A[i] + sum[i - 1][j - A[i]], sum[i - 1][j]);
                }
            }
        }
        return sum[n - 1][m - 1];
    }
}
