public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        int len = chars.length;
        if (len == 0) {
            return;
        }
        
        int low = 0;
        int up = len - 1;
        int i = 0;
        
        while (i != up) {
            if ('a' <= chars[i] && chars[i] <= 'z') {
                swap(chars, low++, i);
            } else {
                // swap with highbit: current bit is not done yet.
                swap(chars, up--, i--);
            }
            i++;
        }
    }
    
    public void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}

