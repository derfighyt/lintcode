public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
        int n = nums.size();
        ArrayList<Integer> result = new ArrayList();
        int i = n - 2;
        while (i >= 0 && nums.get(i) <= nums.get(i + 1)) {//找到第一个逆序数nums[i]
            i--;
        }
        if (i >= 0) {
            //逆序数往后的，找到第一个比逆序数小的数nums[j]，与nums[i]做交换
            int j = n - 1;
            while (nums.get(j) >= nums.get(i)) {
                j--;
            }
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
        }
        for (int k = 0; k <= i; k++) {//逆序数往前的都不用动
            result.add(nums.get(k));
        }
        //逆序数往后的，直接翻转
        for (int k = n - 1; k > i; k--) {
            result.add(nums.get(k));
        }
        return result;
    }
}
// 给定一个整数数组来表示排列，找出其上一个排列。
//
//  注意事项
//
// 排列中可能包含重复的整数
//
// 样例
// 给出排列[1,3,2,3]，其上一个排列是[1,2,3,3]
//
// 给出排列[1,2,3,4]，其上一个排列是[4,3,2,1]
