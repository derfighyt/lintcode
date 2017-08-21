public class Solution {
    /*
     * @param A: An integer array
     * @return: An integer array
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        // 整体思路还是把两个数字区分成两组，分别做异或，之前自己思路是靠奇偶数，但是区分不了
        // 这里是靠最右边的一个1，因为异或，这个位在两个数里分别是0和1，就可以区分
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }

        int lastBit = xor - (xor & (xor - 1)); //保留最右边是1的位，用来区分两个数字
        int group0 = 0, group1 = 0;
        for (int i = 0; i < A.length; i++) {
            if ((lastBit & A[i]) == 0) {
                group0 ^= A[i];
            } else {
                group1 ^= A[i];
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(group0);
        result.add(group1);
        return result;

    }
};
// 给出2*n + 2个的数字，除其中两个数字之外其他每个数字均出现两次，找到这两个数字。
//
// 样例
// 给出 [1,2,2,3,4,4,5,3]，返回 1和5
//
// 挑战
// O(n)时间复杂度，O(1)的额外空间复杂度
