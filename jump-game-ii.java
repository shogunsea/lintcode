public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        
        int start = len - 1;
        int steps = 0;
        
        while (start != 0) {
            for (int i = 0; i < start; i++) {
                if (i + A[i] >= start) {
                    start = i;
                    steps++;
                    break;
                }
            }
        }
        
        return steps;
        
    }
}

