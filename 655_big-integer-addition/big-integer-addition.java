public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // Write your code here
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        String result = "";
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int a = (int)(num1.charAt(i--) - '0');
            int b = (int)(num2.charAt(j--) - '0');
            int c = a + b + carry;
            if (c > 9) {
                carry = 1;
                c = c % 10;
            } else {
                carry = 0;
            }
            result = c + result;
        }

        while (i >= 0) {
            int a = (int)(num1.charAt(i--) - '0');
            int c = a + carry;
            if (c > 9) {
                carry = 1;
                c = c % 10;
            } else {
                carry = 0;
            }
            result = c + result;
        }

        while (j >= 0) {
            int b = (int)(num2.charAt(j--) - '0');
            int c = b + carry;
            if (c > 9) {
                carry = 1;
                c = c % 10;
            } else {
                carry = 0;
            }
            result = c + result;
        }

        if (carry == 1) {
            result = "1" + result;
        }

        return result;
    }
}
