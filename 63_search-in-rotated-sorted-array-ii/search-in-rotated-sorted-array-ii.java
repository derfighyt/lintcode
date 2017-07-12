public class Solution {
    /**
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean
     */
    public boolean search(int[] A, int target) {
        // write your code here
        //最坏情况就是O(n)的复杂度，所以直接循环
        if (A == null || A.length == 0) {
            return false;
        }
        for (int num : A) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
