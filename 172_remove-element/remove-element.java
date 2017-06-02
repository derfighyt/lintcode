/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/remove-element
@Language: Java
@Datetime: 17-05-27 08:27
*/

public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = 0;
        int count = 0;
        for (i = 0; i < A.length;) {
            if (A[i] == elem) {
                int j = 0;
                for (j = i + 1; j < A.length; j++) {
                    if (A[j] != elem) {
                        A[i] = A[j];
                        A[j] = elem;
                        break;
                    }
                }
                if (j == A.length) {
                    break;
                }
            }
            i++;
        }
        return i;
    }
}
