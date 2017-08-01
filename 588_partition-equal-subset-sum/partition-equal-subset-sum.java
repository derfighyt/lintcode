public class Solution {
    public boolean canPartition(int[] nums) {
        //这个动态规划思路比较巧，因为最大和不超过20000，计算每个和是否能达到。
        //但是觉得还是会超时，可以再优化
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < len ; i++ ){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        sum /= 2;
        boolean [] dp = new boolean[10000];
        for(int i = 0; i <=sum ; i ++)
            dp[i] = false;
        dp[0] = true;

        int sum1 = 0;
        for(int i = 0; i < len; i++){
            sum1 += nums[i];
            for(int j= sum1 ; j >= nums[i]; j--){
                dp[j] |= dp[j - nums[i]];
            }
            if (dp[sum]) {
                return true;
            }
        }
        return dp[sum];
    }
}

// Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
// such that the sum of elements in both subsets is equal.
//
//  注意事项
//
// Each of the array element will not exceed 100.
// The array size will not exceed 200.
//
// 样例
// Given nums = [1, 5, 11, 5], return true
// two subsets: [1, 5, 5], [11]
//
// Given nums = [1, 2, 3, 9], return false
