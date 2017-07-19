public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        int n = gas.length;

        int pos = 0;
        int start = 0;
        int totalGas = 0;
        int totalCost = 0;
        while (start < n) {
            while (start < n && cost[start] > gas[start]) {
                start++;
            }
            if (start == n) {
                return -1;
            } else {
                pos = start;
                while (totalGas >= totalCost) {
                    totalGas += gas[pos];
                    totalCost += cost[pos];
                    pos = (pos + 1) % n;
                    if (pos == start) {
                        if (totalGas >= totalCost) {
                            return start;
                        } else {
                            return -1;
                        }
                    }
                }
                if (start > pos) {
                    return -1;
                }
                start = pos;
                totalGas = 0;
                totalCost = 0;
            }
        }
        return -1;
    }
}


// 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油gas[i]，并且从第_i_个加油站前往第_i_+1个加油站需要消耗汽油cost[i]。
// 你有一辆油箱容量无限大的汽车，现在要从某一个加油站出发绕环路一周，一开始油箱为空。
// 求可环绕环路一周时出发的加油站的编号，若不存在环绕一周的方案，则返回-1。
//
//  注意事项
//
// 数据保证答案唯一。O(n)时间和O(1)额外空间
//
// 样例
// 现在有4个加油站，汽油量gas[i]=[1, 1, 3, 1]，环路旅行时消耗的汽油量cost[i]=[2, 2, 1, 1]。则出发的加油站的编号为2。
