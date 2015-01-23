class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        // 1, 2, 4, 8, 16
        // 000001  1
        // 000010  2
        // 000100  4
        // 001000  8
        // 010000  16
        
        // 001000
        // 000111
        
        // 001001
        // 001000
        
        // 001100
        // 001011
        
        // 000000
        
        // 111111
        // 111110
        // 111110 
        
        if (n == 0 || n < 0) {
            return false;
        }
        
        return (n & (n - 1)) == 0;
    }
};
