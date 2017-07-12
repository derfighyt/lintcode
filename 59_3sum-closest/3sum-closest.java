public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length < 3) {
            return 0;
        }

        Arrays.sort(numbers);
        long distance = Long.MAX_VALUE;
        int result = 0;
        int n = numbers.length;
        int i = 0;
        int min = numbers[0] + numbers[1] + numbers[2];
        int max = numbers[n - 3] + numbers[n - 2] + numbers[n - 1];
        if (target <= min) {
            return min;
        } else if (target >= max) {
            return max;
        }
        while (i < n - 2) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                i++;
                continue;
            }

            int now = numbers[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = now + numbers[j] + numbers[k];
                if (Math.abs(target - sum) < distance) {
                    result = sum;
                    distance = Math.abs(target - sum);
                }

                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    return sum;
                }
            }
            i++;
        }
        return result;
    }
}
