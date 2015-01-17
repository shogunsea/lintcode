class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        int sum = a ^ b; // add without carry
        int carry = (a & b) << 1; // carry without sum;
        return aplusb(sum, carry);
    }
};