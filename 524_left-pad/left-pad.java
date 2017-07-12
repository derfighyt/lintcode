public class StringUtils {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        // Write your code here
        return leftPad(originalStr, size, ' ');
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // Write your code here
        if (originalStr.length() >= size) {
            return originalStr;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size - originalStr.length(); i++) {
            result.append(padChar);
        }
        result.append(originalStr);
        return result.toString();
    }
}
