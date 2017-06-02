/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/search-insert-position
@Language: Java
@Datetime: 17-05-27 08:46
*/

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if (A == null) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        int index = 0;
        while (start <= end) {
            index = (end - start) / 2 + start;
            if (A[index] == target) {
                return index;
            } else if (A[index] > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return end + 1;
    }
}
