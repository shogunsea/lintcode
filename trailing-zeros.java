class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
       long res = 0;
       long seed = 5;
       
       while (n / seed >= 1) {
           res += (n / seed);
           seed *= 5;
       }
       
       return res;
    }
    
};

