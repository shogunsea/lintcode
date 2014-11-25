class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        
        int start = 0;
        int end = len - 1;
        
        while (start + 1 < end) {
            int mid = (start + end ) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] < A[mid - 1]) {
                // left half has a peek: cuz left end is increasing, 
                // left-half mid intersection is decreasing.
                end = mid;
            } else if (A[mid] < A[mid + 1]) {
                // right half has a peek.
                // infinite loop possible!!!!
                start = mid;
            }
        }
        
        if (A[start] > A[start - 1] && A[start] > A[start + 1]) {
            return start;
        } else if (A[end] > A[end - 1] && A[end] > A[end + 1]) {
            return end;
        }
        
        return -1;
        
        
    }
}

