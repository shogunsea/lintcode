public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        // dups: O(n) time.
        int len = num.length;
        if (len == 0) {
            return 0;
        }
        
        int start = 0;
        int end = len - 1;
        
        return minHelper(num, start, end);
    }
    
    public int minHelper(int[] num, int start, int end) {
        if (start == end) {
            return num[start];
        }
        
        int leftMin, rightMin;
        int mid = (start + end) / 2;
        if (num[start] <= num[mid]) {
            leftMin = num[start];
            rightMin = minHelper(num, mid + 1, end);
        } else {
            leftMin = minHelper(num, start, mid);
            rightMin = num[mid + 1];
        }
        
        return leftMin < rightMin? leftMin : rightMin;
    }
}
