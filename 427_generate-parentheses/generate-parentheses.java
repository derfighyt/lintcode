public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
     public ArrayList<String> generateParenthesis(int n) {
         ArrayList<String> result = new ArrayList<String>();
         if (n <= 0) {
             return result;
         }
         helper(result, "", n, n);
         return result;
     }

 	public void helper(ArrayList<String> result,
 	                   String paren, // current paren
 	                   int left,     // how many left paren we need to add
 	                   int right) {  // how many right paren we need to add
 		if (left == 0 && right == 0) {
 			result.add(paren);
 			return;
 		}

         if (left > 0) {
 		    helper(result, paren + "(", left - 1, right);
         }

         if (right > 0 && left < right) {
 		    helper(result, paren + ")", left, right - 1);
         }
 	}

}
// 给定 n 对括号，请写一个函数以将其生成新的括号组合，并返回所有组合结果。
// 样例
// 给定 n = 3, 可生成的组合如下:
//
// "((()))", "(()())", "(())()", "()(())", "()()()"
