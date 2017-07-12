public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if (k == 0 || A == null || A.length() == 0) {
            return A;
        }
        //如果存在某位数字大于其后面的数字，应该先删掉，否则删掉后面的数字会导致整体后移，结果反而较大
        //1 5 4 7 8 2
        //  1 4 7 8 2
        //如果不存在，则从后面开始删除较大的数。
        //1 2 3 4 5
        //  1 2 3 4
        Stack<Character> stack = new Stack();
        int count = 0;
        for (char c : A.toCharArray()) {
            while (count < k && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                count++;
            }
            stack.push(c);
        }
        while (count < k) {
            stack.pop();
            count++;
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        int index = 0;
        while (result.charAt(index) == '0') {//去0
            index++;
        }
        return result.substring(index);
    }
}
