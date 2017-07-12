public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
        List<List<Integer>> result = new ArrayList();
        List<Integer> solution = new ArrayList();

        helper(result, solution, n, k, 1);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> solution, int n, int k, int start) {
        if (solution.size() == k) {
            result.add(new ArrayList(solution));
        }
        for (int i = start; i <= n; i++) {
            solution.add(i);
            helper(result, solution, n, k, i + 1);
            solution.remove(solution.size() - 1);
        }
    }
}
