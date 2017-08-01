public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        // Write your code here
        // 根本就TM不是按字典序
        int n = A.length;
        long result = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet();
            for (int j = i + 1; j < n; j++) {//用i后面比nums[i]小的数字替换i，能产生多少排列
                if (cmp(A[j], A[i]) < 0 && !set.contains(A[j])) {
                    set.add(A[j]);
                    swap(A, i, j);
                    result += cal(A, i);
                    swap(A, i, j);
                }
            }
        }
        return result + 1;
    }

    public long cal(int[] A, int i) {
        int n = A.length;
        long per = perCount(n - i - 1);//排列总数
        Map<Integer, Integer> map = new HashMap();
        long repeat = 1;
        for (int j = i + 1; j < n; j++) {
            if (!map.containsKey(A[j])) {
                map.put(A[j], 1);
            } else {
                map.put(A[j], map.get(A[j]) + 1);
                repeat = repeat * map.get(A[j]);
            }
        }
        return per / repeat;
    }

    public long perCount(int n) {
        long result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }

    public int cmp(int a, int b) {
        return a - b;
        //return String.valueOf(a).compareTo(String.valueOf(b));
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// 给出一个可能包含重复数字的排列，求这些数字的所有排列按字典序排序后该排列在其中的编号。编号从1开始。
//
// 样例
// 给出排列[1, 4, 2, 2]，其编号为3。
