public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    // public boolean isUnique(String str) {
    //     // write your code here
    //     Set<Character> occur = new HashSet<Character>();
    //     for (int i = 0; i < str.length(); i++) {
    //         if (occur.contains(str.charAt(i))){
    //             return false;
    //         } else {
    //             occur.add(str.charAt(i));
    //         }
    //     }
        
    //     return true;
    // }
    
    // O(1) space.
    public boolean isUnique(String str) {
        // write your code here
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                char d = str.charAt(j);
                if (c == d) {
                    return false;
                }
            }
        }
        
        return true;
        
    }
}
