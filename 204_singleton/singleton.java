class Solution {
    /**
     * @return: The same instance of this class every time
     */
    public static Solution getInstance() {
        // write your code here
        if (solution == null) {
            solution = new Solution();
        }
        return solution;
    }

    private Solution() {

    }
    private static Solution solution;
};
