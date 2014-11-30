public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        // use int array of size 26 as the hashmap.
        int aLen = A.length();
        int bLen = B.length();
        if (aLen == 0) {
            return bLen == 0;
        }
        
        int[] count = new int[26];
        
        for (int i = 0; i < aLen; i++) {
            char c = A.charAt(i);
            count[c - 'A'] += 1;
        }
        
        for (int i = 0; i < bLen; i++) {
            char c = B.charAt(i);
            count[c - 'A'] -= 1;
            if (count[c - 'A'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}
