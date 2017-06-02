/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/valid-sudoku
@Language: Java
@Datetime: 17-06-02 03:42
*/

class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        Set <Character> rowSet = new HashSet();
        HashMap <Integer, Set<Character>> colMap = new HashMap ();
        HashMap <Integer, Set<Character>> gridMap = new HashMap();
        for (int i = 0; i < 9; i++) {
            colMap.put(i, new HashSet<Character>());
            gridMap.put(i, new HashSet<Character>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rowSet.contains(board[i][j])) {//判断行是否合法
                    return false;
                } else {
                    //判断列是否合法
                    if (colMap.get(j).contains(board[i][j])) {
                        return false;
                    }
                    //判断格子是否合法
                    if (gridMap.get((i/3)*3 + j/3).contains(board[i][j])) {
                        return false;
                    }
                }
                //都合法就先加入
                rowSet.add(board[i][j]);
                colMap.get(j).add(board[i][j]);
                gridMap.get((i/3)*3 + j/3).add(board[i][j]);
            }
            rowSet.clear();
        }
        return true;
    }
};