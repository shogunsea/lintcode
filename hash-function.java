import java.math.BigInteger;
// import java.util.Map;


class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        
        long res = 0;
        for (int i = 0; i < key.length; i++){
            res = 33 * res + (int)key[i];
            res = res % HASH_SIZE;
        }
        return (int)res;
    }
};
