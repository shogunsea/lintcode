public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(ArrayList<Integer> A, int target) {
        // write your code here
        int len = A.size();
        if (len == 0) {
            return 0;
        }
        
        int start = 0;
        int end = len - 1;
        
        // in the binary search problem, this approach return
        // the first occurance index of target.
        // after the loop we first check the end index, then 
        // check start index.
        while (start + 1 < end) {
            int mid = (start + end ) / 2;
            if (A.get(mid) >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (A.get(end) < target) {
            return end + 1;
        } else if (A.get(end) == target) {
            return end;
        } else if (A.get(start) < target) {
            return start + 1;
        } else {
            return start;
        }
    }
}

