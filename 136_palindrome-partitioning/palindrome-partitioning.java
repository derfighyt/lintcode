public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList();
        if (s == null || s.length() == 0) {
            return result;
        }
        if (s.length() == 1) {
            List<String> ans = new ArrayList();
            ans.add(s);
            result.add(ans);
        } else { //长度超过1
            if (isPalindrome(s)) { //先判断自己是不是回文
                List<String> ans = new ArrayList();
                ans.add(s);
                result.add(ans);
            }
            //从两端往下切相同的子串
            
        }


        return result;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
// 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
// 返回s所有可能的回文串分割方案。
//
// 样例
// 给出 s = "aab"，返回
//
// [
//   ["aa", "b"],
//   ["a", "a", "b"]
// ]
