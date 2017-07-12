class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList());
            return result;
        }
        int n = nums.length;
        Arrays.sort(nums);
        helper(result, nums, n);
        return result;
    }

    public void helper(ArrayList<ArrayList<Integer>> result, int[] nums, int size) {
        if (size == 0) {
            result.add(new ArrayList<Integer>());
            return;
        }
        helper(result, nums, size - 1);
        ArrayList<ArrayList<Integer>> tmp = new ArrayList();
        for (ArrayList<Integer> list : result) {
            tmp.add(new ArrayList(list));
            list.add(nums[size - 1]);
        }
        result.addAll(tmp);
    }
}
