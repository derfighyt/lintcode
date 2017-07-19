public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        int base = 0;
        ArrayList<Integer> result = new ArrayList();
        result.add(base);

        List<Integer> changeBit = new ArrayList();
        for (int i = 1; i <= n; i++) {
            int start = changeBit.size();
            changeBit.add(i);
            changeBit.addAll(changeBit.subList(0, changeBit.size() - 1));
            for (int j = start; j < changeBit.size(); j++) {//变换对应的位
                int bit = changeBit.get(j);
                if ((base & 1 << (bit - 1)) == 0) {//相应位为0，变成1
                    base = base | 1 << (bit - 1);
                } else {//相应位为1，变成0
                    base = base & ((~0 << bit) ^ (1 << (bit - 1) - 1));
                }
                result.add(base);
            }
        }
        return result;
    }
}

// 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个二进制的差异。
//
// 给定一个非负整数 n ，表示该代码中所有二进制的总数，请找出其格雷编码顺序。一个格雷编码顺序必须以 0 开始，并覆盖所有的 2n 个整数。
//
//  注意事项
//
// 对于给定的 n，其格雷编码顺序并不唯一。
//
// 根据以上定义， [0,2,3,1] 也是一个有效的格雷编码顺序。
//
// 样例
// 给定 n = 2， 返回 [0,1,3,2]。其格雷编码顺序为：
//
// 00 - 0
// 01 - 1
// 11 - 3
// 10 - 2
