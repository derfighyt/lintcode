public class Solution {
    /*
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        Arrays.sort(S);

        int n = S.length;
        int count = 0;
        if (n < 3) {
            return count;
        }
        int i = 0;
        while (i < n - 2) {
            int j = i + 1;
            while (j < n - 1) {
                int k = j + 1;
                while (k < n && S[i] + S[j] > S[k]) {
                    count++;
                    k++;
                }
                j++;
            }
            i++;
        }
        return count;
    }
}
// 给定一个整数数组，在该数组中，寻找三个数，分别代表三角形三条边的长度，问，可以寻找到多少组这样的三个数来组成三角形？
//
// 样例
// 例如，给定数组 S = {3,4,6,7}，返回 3
//
// 其中我们可以找到的三个三角形为：
//
// {3,4,6}
// {3,6,7}
// {4,6,7}
// 给定数组 S = {4,4,4,4}, 返回 4
//
// 其中我们可以找到的三个三角形为：
//
// {4(1),4(2),4(3)}
// {4(1),4(2),4(4)}
// {4(1),4(3),4(4)}
// {4(2),4(3),4(4)}
