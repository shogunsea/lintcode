class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int pointer = m + n - 1;
        
        while (pointer >= 0) {
            if (m > 0 && n > 0) {
                if (A[m - 1] > B[n - 1]) {
                    A[pointer--] = A[m - 1];
                    m--;
                } else {
                    A[pointer--] = B[n - 1];
                    n--;
                }
            } else {
                if (m > 0) {
                    A[pointer--] = A[m - 1];
                    m--;
                } else {
                    A[pointer--] = B[n - 1];
                    n--;
                }
            }
        }
        
    }
}

// To reduce the code:
class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int pointer = m + n - 1;
        
        while (pointer >= 0) {
            if ((m > 0 && n > 0 && A[m - 1] > B[n - 1]) || (n <= 0 && m > 0)) {
                A[pointer--] = A[m - 1];
                m--;
            } else if ((m > 0 && n > 0 && A[m - 1] <= B[n - 1]) || (m <= 0&& n > 0)){
                A[pointer--] = B[n - 1];
                n--;
            }
        }
        
    }
}
