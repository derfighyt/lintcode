public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> result = new ArrayList();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Set<String> set = new HashSet();
        int num = digits.charAt(0) - '0';
        for (int i = 0; i < map[num].length(); i++) {
            set.add(String.valueOf(map[num].charAt(i)));
        }

        for (int i = 1; i < digits.length(); i++) {
            Set<String> tmp = set;
            set = new HashSet();
            num = digits.charAt(i) - '0';
            for (int j = 0; j < map[num].length(); j++) {
                for (String str : tmp) {
                    set.add(str + map[num].charAt(j));
                }
            }
        }

        for (String str : set) {
            result.add(str);
        }
        return result;
    }
}
// Given a digit string excluded 01, return all possible letter combinations that the number could represent.
// A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//  注意事项
//
// 以上的答案是按照词典编撰顺序进行输出的，不过，在做本题时，你也可以任意选择你喜欢的输出顺序。
//
// 样例
// 给定 "23"
//
// 返回 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
