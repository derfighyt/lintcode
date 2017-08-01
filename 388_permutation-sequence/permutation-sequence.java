public class Solution {
    /*
     * @param : n
     * @param : the k th permutation
     * @return: return the k-th permutation
     */
    public String getPermutation(int n, int k) {
        // write your code here
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {//数字数组
            nums[i] = 1;
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {//依次确定出每个位置的数字
            int fac = fac(n - i - 1); //当前数字往后还有多少排列
            int index = 0; //当前位置应该填充第几小的，且没使用过的数字
            if (fac == 1) { //最后两个数字特殊处理
                index = k;
            } else if (k % fac == 0) {
                index = k / fac;
            } else {
                index = k / fac + 1;
            }
            if (index > 0) {
                k = k - (index - 1) * fac;
            }
            for (int j = 0; j < n; j++) {
                if (index > 0 && nums[j] == 1) {
                    index--;
                }
                if (index == 0) {
                    result[i] = j + 1;
                    nums[j] = 0;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public int fac(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }
};
// 给定 n 和 k，求123..n组成的排列中的第 k 个排列。
//
//  注意事项
//
// 1 ≤ n ≤ 9
//
// 样例
// 对于 n = 3, 所有的排列如下：
//
// 123
// 132
// 213
// 231
// 312
// 321
// 如果 k = 4, 第4个排列为，231.
//
// 挑战
// O(n*k) in time complexity is easy, can you do it in O(n^2) or less?
