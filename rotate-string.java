public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char [] rotateString(char [] A, int offset) {
        // wirte your code here
        int len = A.length;
        if (len == 0) {
            return A;
        }
        offset %= len;
        reverse(A, 0, len - 1 - offset);
        reverse(A, len - offset, len - 1);
        reverse(A, 0, len - 1);
        return A;
    }
    
    public void reverse(char[] A, int start, int end) {
        while (start < end) {
            swap(A, start++, end--);
        }
    }
    
    public void swap(char[] A, int a, int b) {
        char temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
};
