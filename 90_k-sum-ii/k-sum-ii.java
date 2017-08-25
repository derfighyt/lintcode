public class Solution {
    ArrayList<ArrayList<Integer>> result = new ArrayList();
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        Arrays.sort(A);
        helper(A, k, target, 0, new ArrayList(), 0);
        return result;
    }

    public void helper(int[]A, int k, int target, int p, ArrayList<Integer> list, int sum) {
        if (p == A.length) {
            return;
        }
        list.add(A[p]);
        sum += A[p];

        if (sum == target && list.size() == k) {
            result.add(new ArrayList(list));
        } else if (sum < target && list.size() < k){
            helper(A, k, target, p + 1, list, sum);
        }

        list.remove(list.size() - 1);
        sum -= A[p];
        helper(A, k, target, p + 1, list, sum);
    }
}
// Your title here...Given n unique integers, number k (1<=k<=n) and target.
//
// Find all possible k integers where their sum is target.
//
// 样例
// 给出[1,2,3,4]，k=2， target=5，返回 [[1,4],[2,3]]
