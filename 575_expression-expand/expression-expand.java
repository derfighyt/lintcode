public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<String> stack = new Stack();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (isNumber(c)) {
                int j = i + 1;
                while (j < s.length() && isNumber(s.charAt(j))) {
                    j++;
                }
                stack.push(s.substring(i, j));
                i = j;//直接忽略掉数字后跟的[
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                while (!isNumber(stack.peek().charAt(0))) {
                    tmp.insert(0, stack.pop());
                }
                int times = Integer.parseInt(stack.pop());
                String str = tmp.toString();
                tmp = new StringBuilder();
                while (times > 0) {
                    tmp.append(str);
                    times--;
                }
                if (tmp.length() > 0) {
                    stack.push(tmp.toString());
                }
            } else {
                stack.push(s.substring(i, i + 1));
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public boolean isNumber(char c) {
        if ((c - '0') >= 0 && (c - '0') <= 9) {
            return true;
        }
        return false;
    }
}

// Given an expression s includes numbers, letters and brackets.
// Number represents the number of repetitions inside the brackets(can be a string or another expression)．
// Please expand expression to be a string.
//
// 样例
// s = abc3[a] return abcaaa
// s = 3[abc] return abcabcabc
// s = 4[ac]dy, return acacacacdy
// s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz
