public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
        //就是对数字做字典排序
        dicSort(num, 0, num.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int n : num) {
            sb.append(n);
        }

        while (sb.length() > 1 && sb.charAt(0) == '0' && sb.charAt(1) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public void dicSort(int[] num, int start, int end) {
        if (start >= end) {
            return;
        }
        int priot = num[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && compare(num[j], priot) < 0) {
                j--;
            }
            if (i < j) {
                num[i] = num[j];
            }
            while (i < j && compare(num[i], priot) >= 0) {
                i++;
            }
            if (i < j) {
                num[j] = num[i];
            }
        }
        num[i] = priot;
        dicSort(num, start, i - 1);
        dicSort(num, i + 1, end);
    }

    public int compare(int a, int b) {
        String x = String.valueOf(a);
        String y = String.valueOf(b);
        int i = 0, j = 0, k = 0;
        int max = Math.max(x.length(), y.length());
        while (k < max) {
            k++;
            if (x.charAt(i) > y.charAt(j)) {
                return 1;
            } else if (x.charAt(i) < y.charAt(j)) {
                return -1;
            } else {
                i = (i + 1) % x.length();
                j = (j + 1) % y.length();
            }
        }
        return 0;
    }
}
// 给出一组非负整数，重新排列他们的顺序把他们组成一个最大的整数。
//
//  注意事项
//
// 最后的结果可能很大，所以我们返回一个字符串来代替这个整数。
//
// 样例
// 给出 [1, 20, 23, 4, 8]，返回组合最大的整数应为8423201。
//
// 挑战
// 在 O(nlogn) 的时间复杂度内完成。
