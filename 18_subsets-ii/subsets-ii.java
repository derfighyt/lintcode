public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList());
            return result;
        }
        int n = nums.length;
        Arrays.sort(nums);

        Map<String, List<Integer>> map = new HashMap();
        map.put("", new ArrayList());
        for (int num : nums) {
            Map<String, List<Integer>> tmp = new HashMap();
            for (String key : map.keySet()) {
                List<Integer> list = new ArrayList(map.get(key));
                list.add(num);
                tmp.put(key + "-" + num, list);
            }
            map.putAll(tmp);
        }
        return new ArrayList(map.values());
    }
}
// 给定一个可能具有重复数字的列表，返回其所有可能的子集
//
//  注意事项
//
// 子集中的每个元素都是非降序的
// 两个子集间的顺序是无关紧要的
// 解集中不能包含重复子集
// 样例
// 如果 S = [1,2,2]，一个可能的答案为：
//
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
// 挑战
// 你可以同时用递归与非递归的方式解决么？
