/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/longest-words
@Language: Java
@Datetime: 17-06-02 08:41
*/

class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        int max = 0;
        ArrayList<String> result = new ArrayList<String>();
        for (String word : dictionary) {
            if (word.length() > max) {
                max = word.length();
                result.clear();
                result.add(word);
            } else if (word.length() == max) {
                result.add(word);
            }
        }
        return result;
    }
};