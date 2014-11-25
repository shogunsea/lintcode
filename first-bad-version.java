/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge wether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int start = 1;
        int end = n;
        
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (VersionControl.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }        
        
        if (VersionControl.isBadVersion(start)) {
            return start;
        }
        if (VersionControl.isBadVersion(end)) {
            return end;
        }
        
        return -1;
    }
}

