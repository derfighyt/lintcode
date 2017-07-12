public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList();
        List<Integer> solution = new ArrayList();
        Arrays.sort(candidates);

        helper(result, solution, 0, candidates, target, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> solution,
     int sum, int[] candidates, int target, int start) {
        if (sum == target) {
            result.add(new ArrayList(solution));
            return;
        } else if (sum > target) {
            return;
        }

        int removed = 0;
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] == removed) {
                continue;
            }
            solution.add(candidates[i]);
            sum += candidates[i];
            helper(result, solution, sum, candidates, target, i);
            removed = solution.get(solution.size() - 1);
            solution.remove(solution.size() - 1);
            sum -= removed;
        }
    }
}
