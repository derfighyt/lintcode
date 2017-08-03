public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public String minNumber(int[] nums) {
        // Write your code here
        sort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end;
        int priot = nums[i];
        while (i < j) {
            while (i < j && cmp(nums[j], priot) >= 0) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
            }
            while (i < j && cmp(nums[i], priot) < 0) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = priot;
        sort(nums, start, i - 1);
        sort(nums, i + 1, end);
    }

    public int cmp(int a, int b) {
        String x = String.valueOf(a) + b;
        String y = String.valueOf(b) + a;
        return x.compareTo(y);
    }
}
// 给定一个整数数组，请将其重新排序，以构造最小值。
//
//  注意事项
//
// The result may be very large, so you need to return a string instead of an integer.
//
// 样例
// 给定 [3, 32, 321]，通过将数组重新排序，可构造 6 个可能性数字：
//
// 3+32+321=332321
// 3+321+32=332132
// 32+3+321=323321
// 32+321+3=323213
// 321+3+32=321332
// 321+32+3=321323
// 其中，最小值为 321323，所以，将数组重新排序后，该数组变为 [321, 32, 3]。
//
// 挑战
// 在原数组上完成，不使用额外空间。
