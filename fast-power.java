class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        // ab mod n = ((a mod n)(b mod n)) mod n
        // Similar to the power problem in Leetcode.
        // when halving the power should 
        // consider the even and odd case.
        // If its odd case, should update the mod equation
        // accordingly.
        if (n <= 1) {
            return (int)Math.pow(a, n) % b;
        }
        
        long half = fastPower(a, b, n / 2);
        if (n % 2 == 0) {
            // even case.
            return (int)((half * half) % b);
        } else {
            // odd case
            // a(bc) mod n = ((a mod n)(bc mod n)) mod n
            // --> bc mod n = ((b mod n)(c mod n)) mod n
            // hMs: half Multiply single
            long hMs = ((half % b) * (a % b)) % b;
            return (int)((half * hMs) % b);
        }
    }
};
