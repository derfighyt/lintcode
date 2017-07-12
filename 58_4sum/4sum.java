public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if (numbers == null || numbers.length < 4) {
            return result;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 4; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int now = numbers[i];
            ArrayList<ArrayList<Integer>> list = threeSum(numbers, target - now, i + 1, numbers.length);
            for (ArrayList<Integer> l : list) {
                l.add(0, now);
                result.add(l);
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers, int target, int start, int end) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList();

        int n = end;
        int i = start;
        while (i < n) {
            int now = numbers[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = numbers[j] + numbers[k] + now;
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    ArrayList<Integer> list = new ArrayList();
                    list.add(now);
                    list.add(numbers[j++]);
                    list.add(numbers[k--]);
                    result.add(list);
                    while (j < k && numbers[j - 1] == numbers[j]) {
                        j++;
                    }
                    while (j < k && numbers[k + 1] == numbers[k]) {
                        k--;
                    }
                }
            }
            i++;
            while(i < n && numbers[i - 1] == numbers[i]) {
                i++;
            }
        }
        return result;
    }
}
