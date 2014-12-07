public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        int len = s.length();
        if (len == 0) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        // if we cannot use the built in split function
        // we just iterate through the stirng and 
        // find the valid substirngs.
        String[] ss = s.split(" ");
        
        for (int i = ss.length - 1; i >= 0; i--) {
            if (sb.length() == 0 ) {
                sb.append(ss[i]);
            } else {
                sb.append(" " + ss[i]);
            }
        }
        
        return sb.toString();
    }
}

