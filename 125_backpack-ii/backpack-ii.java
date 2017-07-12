public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if (m <= 0 || A == null || A.length <= 0) {
            return 0;
        }
        int n = A.length;
        int[] result = new int[m]; //1-m容量的背包中间结果
        for (int i = 0; i < n; i++) {
            //计算仅有前i+1个物品时的最优解
            for (int j = m - 1; j >= 0; j--) {
                //从后面计算以避免中间结果被覆盖
                if (j + 1 > A[i]) {
                    result[j] = Math.max(result[j], V[i] + result[j - A[i]]);
                } else if (j + 1 == A[i]) {
                    result[j] = V[i];
                }
            }
        }
        return result[m - 1];
    }
}
