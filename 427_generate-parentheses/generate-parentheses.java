public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> result = new ArrayList();
        if (n == 1) {
            result.add("()");
            return result;
        }
        ArrayList<String> list = generateParenthesis(n - 1);
        Set<String> set = new HashSet();
        for (String str : list) {
            set.add("()" + str);
            for (int i = 1; i < str.length(); i++) {
                set.add(str.substring(0, i) + "()" + str.substring(i));
            }
            set.add(str + "()");
        }
        result.addAll(set);
        return result;
    }
}
// 给定 n 对括号，请写一个函数以将其生成新的括号组合，并返回所有组合结果。
// 样例
// 给定 n = 3, 可生成的组合如下:
//
// "((()))", "(()())", "(())()", "()(())", "()()()"
