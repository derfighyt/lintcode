class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        // write your code here
        //给出数组[-1, -2, -3, 4, 5, 6]，重新排序之后，变成[-1, 5, -2, 4, -3, 6]或者其他任何满足要求的答案
        int n = A.length;
        int count = 0;
        for (int num : A) {
            if (num > 0) {//统计正数个数
                count++;
            }
        }
        int flag = 1;//代表奇偶性，1表示应该以负数开头，0表示以正数开头
        if (count > n / 2) {
            flag = 0;//
        }
        int a = 0, b = 0;
        while (a < n && b < n) {
            while (a < n && (a % 2 == flag || A[a] < 0)) {//flag=1时，正数应该在奇数位，找到偶数位的正数
                a++;
            }
            while (b < n && (b % 2 == 1 - flag || A[b] > 0)) {//flag=1时，负数应该在偶数位，找到奇数位的正数
                b++;
            }
            if (a == n || b == n) {
                break;
            }
            int tmp = A[a];
            A[a++] = A[b];
            A[b++] = tmp;
        }
    }
}
