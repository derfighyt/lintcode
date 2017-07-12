public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList();
        List<Integer> solution = new ArrayList();

        Arrays.sort(num);
        helper(result, solution, num, target, 0, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> solution,
        int[] num, int target, int sum, int start) {
        if (sum == target) {
            result.add(new ArrayList(solution));
            return;
        } else if (sum > target) {
            return;
        }

        int removed = 0;
        for (int i = start; i < num.length; i++) {
            if (removed == num[i]) {
                continue;
            }
            solution.add(num[i]);
            sum += num[i];
            helper(result, solution, num, target, sum, i + 1);
            removed = solution.get(solution.size() - 1);
            solution.remove(solution.size() - 1);
            sum -= removed;
        }
    }
}
