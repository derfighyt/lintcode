public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.size() == 0) {
            return null;
        }
        ArrayList<Long> tmp = new ArrayList<Long>();
        tmp.add(1L);
        //6, 3, 1
        long pro = 1;
        for (int i = A.size() - 2; i >= 0; i--) {
            pro = A.get(i + 1) * pro;
            tmp.add(0, pro);
        }

        result.add(tmp.get(0));
        pro = 1;
        for (int i = 1; i < A.size(); i++) {
            pro = A.get(i - 1) * pro;
            result.add(pro * tmp.get(i));
        }
        return result;
    }
}
