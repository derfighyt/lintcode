public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        // Write your code here
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        int m = num1.length();
        int n = num2.length();

        //转成整型数组
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i] = (int)(num1.charAt(i) - '0');
        }
        for (int j = 0; j < n; j++) {
            arr2[j] = (int)(num2.charAt(j) - '0');
        }
        //
        int[] result = new int[m + n + 2];
        int carry = 0;
        int i, j;
        for (j = n - 1; j >= 0; j--) {
            if (arr2[j] != 0) {
                //0直接跳过
                for (i = m - 1; i >= 0; i--) {
                    int offset = i + j + 3;
                    result[offset] = arr2[j] * arr1[i] + result[offset] + carry;
                    carry = result[offset] / 10;
                    result[offset] = result[offset] % 10;
                }
                result[i + j + 3] = carry;
                carry = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        while (i < result.length) {
            sb.append(result[i++]);
        }
        if (sb.length() == 0) {
            sb.append(0);
        }
        return sb.toString();

    }
}
