public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        if (numbers == null || numbers.length < 3) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList();
        Arrays.sort(numbers);

        int n = numbers.length;
        int i = 0;
        while (i < n) {
            int now = numbers[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = numbers[j] + numbers[k] + now;
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
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
