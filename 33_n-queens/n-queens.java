class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
    }
};
// n皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。
// 给定一个整数n，返回所有不同的n皇后问题的解决方案。
// 每个解决方案包含一个明确的n皇后放置布局，其中“Q”和“.”分别表示一个女王和一个空位置。
// 样例
// 对于4皇后问题存在两种解决的方案：
//
// [
//     [".Q..", // Solution 1
//      "...Q",
//      "Q...",
//      "..Q."],
//     ["..Q.", // Solution 2
//      "Q...",
//      "...Q",
//      ".Q.."]
// ]
//
// 挑战
// 你能否不使用递归完成？
