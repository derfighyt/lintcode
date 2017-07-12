public class Solution {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        int start = 0, end = chars.length - 1;
        while (start < end) {
            while (start < end && chars[start] > 'Z') {
                start++;
            }
            while (start < end && chars[end] < 'a') {
                end--;
            }
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }
}
