public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList();
        if (A == null || A.length == 0) {
            return result;
        }

        int sum = 0;
        int a = 0;
        int b = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0) {
                sum = A[i];
                a = b = i;
            } else {
                sum += A[i];
                b = i;
            }
            if (sum >= max) {
                max = sum;
                result.clear();
                result.add(a);
                result.add(b);
            }
        }
        return result;
    }
}
