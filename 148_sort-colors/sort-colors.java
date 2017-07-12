class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        partitionArray(nums, 1);
    }

    public int partitionArray(int[] nums, int k) {
	    //write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] < k) {
                start++;
            }
            while (start < end && nums[end] > k) {
                end--;
            }
            if (nums[start] > nums[end]) {
                swap(nums, start, end);
            } else if (start < end){
                int i;
                for (i = start + 1; i < end; i++) {
                    if (nums[i] < k) {
                        swap(nums, start, i);
                        break;
                    } else if (nums[i] > k) {
                        swap(nums, i, end);
                        break;
                    }
                }
                if (i == end) {
                    break;
                }
            }
        }
        if (nums[start] < k) {
            start++;
        }
        return start;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
