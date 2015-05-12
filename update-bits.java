class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        // 1.set iToj bits in n to 0s.
        // 2.create the mask that has correct shifted position.
        // 3.set mask to N.
        
        // 1111111111
        int mask = ~0;
        for (int p = i; p <= j; p++) {
            // 0000100
            int temp = 1<<p;
            // 1111011
            temp = ~temp;
            mask = mask & temp;
        }
        
        // 111000011 mask
        n = (n & mask);
        m = (m << i);
        n = (n | m);
        return n;
    }
}

