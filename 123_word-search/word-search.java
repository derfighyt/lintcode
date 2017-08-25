public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        int m = board.length;
        int n = board[0].length;

        int[][] visited = new int[m][n];
        int p = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int[][] visited, int i, int j, int p) {
        if (p == word.length() - 1 && visited[i][j] == 0 && board[i][j] == word.charAt(p)) {
            return true;
        }
        if (visited[i][j] == 1 || board[i][j] != word.charAt(p)) {
            return false;
        }

        visited[i][j] = 1;
        if (i > 0 && helper(board, word, visited, i - 1, j, p + 1)) {
            return true;
        } else if (j > 0 && helper(board, word, visited, i, j - 1, p + 1)) {
            return true;
        } else if (i < board.length - 1 && helper(board, word, visited, i + 1, j, p + 1)) {
            return true;
        } else if (j < board[0].length - 1 && helper(board, word, visited, i, j + 1, p + 1)) {
            return true;
        }
        visited[i][j] = 0;
        return false;
    }
}
// 给出一个二维的字母板和一个单词，寻找字母板网格中是否存在这个单词。
// 单词可以由按顺序的相邻单元的字母组成，其中相邻单元指的是水平或者垂直方向相邻。
// 每个单元中的字母最多只能使用一次。
//
// 样例
// 给出board =
// [
//   "ABCE",
//   "SFCS",
//   "ADEE"
// ]
//
// word = "ABCCED"， ->返回 true,
// word = "SEE"，-> 返回 true,
// word = "ABCB"， -> 返回 false.
