class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList());
            return result;
        }

        List<Integer> list = new ArrayList();
        int n = nums.length;
        list.add(nums[0]);
        result.add(list);

        List<List<Integer>> tmp = new ArrayList();
        for (int i = 1; i < n; i++) {
            for (List<Integer> oldList : result) {
                for (int j = 0; j <= i; j++) {
                    List<Integer> newList = new ArrayList(oldList);
                    newList.add(j, nums[i]);
                    tmp.add(newList);
                }
            }
            result = tmp;
            tmp = new ArrayList();
        }
        return result;
    }

}
