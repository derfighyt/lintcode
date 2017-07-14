public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        //一次删掉3个不同的数字
        Map<Integer, Integer> map = new HashMap();
        int n = nums.size();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                if (map.size() < 3) {
                    map.put(num, 1);
                } else {
                    clearMap(map);
                }
            }

        }
        int max = 0;
        int result = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                result = key;
                max = map.get(key);
            }
        }
        return result;
    }

    public void clearMap(Map<Integer, Integer> map) {
        Queue<Integer> queue = new LinkedList();
        for (int key : map.keySet()) {
            queue.add(key);
        }
        while (!queue.isEmpty()) {
            int key = queue.poll();
            if (map.get(key) > 1) {
                map.put(key, map.get(key) - 1);
            } else {
                map.remove(key);
            }
        }
    }
}

// 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的三分之一。
// 样例
// 给出数组[1,2,1,2,1,3,3] 返回 1
