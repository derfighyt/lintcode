public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i > farthest) {
                    farthest = A[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;

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
