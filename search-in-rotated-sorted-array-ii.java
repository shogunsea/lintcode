public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        int len = A.length;
        if (len == 0) {
            return false;
        }
        
        int start = 0;
        int end = len - 1;
        
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) {
                return true;
            }
            
            if (A[mid] > A[start]) {
                // left is sorted
                if (target < A[mid] && A[start] <= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // right is sorted
                if (target > A[mid] && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (A[start] == target || A[end] == target) {
            return true;
        } else {
            return false;
        }
    }
}

