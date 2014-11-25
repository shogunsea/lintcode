public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int len = A.length;
        if (len == 0) {
            return true;
        }
        
        int maxCanReach = A[0];
        for (int i = 0; i < len; i++) {
            if (maxCanReach < i) {
                return false;
            }
            
            int jump = A[i] + i;
            maxCanReach = maxCanReach > jump? maxCanReach : jump;
            if (maxCanReach >= len - 1) {
                return true;
            }
        }
        
        return true;
        
    }
}

