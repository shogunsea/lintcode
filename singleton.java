class Solution {
    /**
     * @return: The same instance of this class every time
     */
     static Solution ins = null;
    public static Solution getInstance() {
        // write your code here
        if (ins == null) {
            ins = new Solution();
        }
        return ins;
    }
};