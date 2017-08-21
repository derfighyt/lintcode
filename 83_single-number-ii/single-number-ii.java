public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int[] bits = new int[32];
        for (int num : A) {
            for (int i = 0; i < 32; i++) {
                bits[i] += num >> i & 1;
                bits[i] %= 3;
            }
        }

        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result = result << 1;
            result += bits[i];
        }
        return result;
    }
}

// 给出3*n + 1 个的数字，除其中一个数字之外其他每个数字均出现三次，找到这个数字。
// 样例
// 给出 [1,1,2,3,3,3,2,2,4,1] ，返回 4
// 一次遍历，常数级的额外空间复杂度
