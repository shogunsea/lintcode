public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        int len = A.length;
        if (len == 0) {
            return -1;
        }
        
        int start = 0;
        int end = len - 1;
        
        // terminate condition: start and end wont overlapping.
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) {
                return mid;
            }
            
            // if left half is sorted:
            if (A[mid] > A[start]) {
                if (target < A[mid] && target >= A[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // right half is sorted
                if (target > A[mid] && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}

