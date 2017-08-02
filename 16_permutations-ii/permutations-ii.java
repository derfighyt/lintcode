class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList();
        Arrays.sort(nums);
        for (int num : nums) {
            list.add(num);
        }
        result.add(new ArrayList(list));
        if (nums == null || nums.length == 0) {
            return result;
        }

        int n = nums.length;
        while (true) {
            int i = n - 1;
            while (i > 0 && list.get(i - 1) >= list.get(i)) {
                i--;
            }
            if (i == 0) {
                break;
            }
            int j = n - 1;
            while (j > i && list.get(j) <= list.get(i - 1)) {
                j--;
            }
            swap(list, i - 1, j);
            j = n - 1;
            while (i < j) {
                swap(list, i, j);
                i++;
                j--;
            }
            result.add(new ArrayList(list));
        }
        return result;
    }

    public void swap(List<Integer> list, int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
// 给出一个具有重复数字的列表，找出列表所有不同的排列。
//
// 样例
// 给出列表 [1,2,2]，不同的排列有：
//
// [
//   [1,2,2],
//   [2,1,2],
//   [2,2,1]
// ]
// 挑战
// 使用递归和非递归分别完成该题。
