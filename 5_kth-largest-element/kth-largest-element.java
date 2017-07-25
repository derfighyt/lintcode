class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        return helper(k, nums, 0, nums.length - 1);
    }

    public int helper(int k, int[] nums, int start, int end) {
        //在start和end区间中找出第k大的数
        int priot = nums[start]; //选取第一个元素作为轴值
        //开始快排
        int i = start, j = end;
        while (i < j) {
            while (i < j && nums[j] < priot) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
            while (i < j && nums[i] >= priot) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        if (i - start == k - 1) {
            return priot;
        } else if (i - start < k - 1) {
            return helper(k + start - 1 - i, nums, i + 1, end);
        } else {
            return helper(k, nums, start, i - 1);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
};

// 在数组中找到第k大的元素
//
//  注意事项
//
// 你可以交换数组中的元素的位置
// 样例
// 给出数组 [9,3,2,4,8]，第三大的元素是 4
//
// 给出数组 [1,2,3,4,5]，第一大的元素是 5，第二大的元素是 4，第三大的元素是 3，以此类推
//
// 挑战
// 要求时间复杂度为O(n)，空间复杂度为O(1)
