public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int n = A.length;
        int[] canReach = new int[n];
        int farest = A[0];
        if (farest >= n - 1) {
            return 1;
        }
        for (int i = 1; i < n; i++) {
            int minStep = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] + j >= i) {
                    minStep = Math.min(minStep, canReach[j] + 1);
                }
            }
            canReach[i] = minStep;
        }
        return canReach[n - 1];
    }
}
// 给出一个非负整数数组，你最初定位在数组的第一个位置。
//
// 数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 样例
// 给出数组A = [2,3,1,1,4]，最少到达数组最后一个位置的跳跃次数是2(从数组下标0跳一步到数组下标1，
// 然后跳3步到数组的最后一个位置，一共跳跃2次)
