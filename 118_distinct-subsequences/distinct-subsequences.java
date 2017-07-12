public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        //    a n a c o n d a s t r e e t r a c e c a r
        // c  0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 3 3 3
        // o  0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
        // n  0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
        // t  0 0 0 0 0 0 0 0 0 1 1 1 1 2 2 2 2 2 2 2 2
        // r  0 0 0 0 0 0 0 0 0 0 1 1 1 1 3 3 3 3 3 3 5
        // a  0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 3 3 3 6 6
        if (S == null) {
            return 0;
        }
        if (T.equals("")) {
            return 1;
        }
        int n = S.length();
        int m = T.length();
        int[][] result = new int[m][n];
        result[0][0] = T.charAt(0) == S.charAt(0) ? 1 : 0;
        for (int j = 1; j < n; j++) { //竖向不用初始化，都是0
            result[0][j] = T.charAt(0) == S.charAt(j) ? result[0][j - 1] + 1 : result[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j < i) {
                    continue;
                }
                if (T.charAt(i) != S.charAt(j)) {//如果两边字母不相等，在j位置能生成T的子序列就是j-1位置的值
                    result[i][j] = result[i][j - 1];
                } else {//如果两边字母相等，在j位置能生成T的子序列就是不使用j位置时的子序列(j-1)与使用j位置时的子序列(i-1,j-1)之和
                    result[i][j] = result[i][j - 1] + result[i - 1][j - 1];
                }
            }
        }
        return result[m - 1][n - 1];
    }
}
