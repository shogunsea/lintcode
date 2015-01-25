public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        int len = num.length;
        if (len == 0) {
            return 0;
        }
        
        return minHelper(num, 0, len - 1);
    }
    
    public int minHelper(int[] num, int start, int end) {
        if (start == end) {
            return num[start];
        }
        
        int mid = (start + end) / 2;
        if (num[start] < num[mid]) {
            // left half is sorted
            int leftMin = num[start];
            int rightMin = minHelper(num, mid + 1, end);
            return leftMin < rightMin? leftMin : rightMin;
        } else {
            int rightMin = num[mid + 1];
            int leftMin = minHelper(num, start, mid);
            return leftMin < rightMin? leftMin : rightMin;
        }
    }
}



public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        int len = num.length;
        if (len == 0) {
            return 0;
        }
        
        return minHelper(num, 0, len - 1);
    }
    
    public int minHelper(int[] num, int start, int end) {
        if (start + 1 == end) {
            return num[start] < num[end]? num[start] : num[end];
        }
        
        int mid = (start + end) / 2;
        if (num[start] < num[mid]) {
            // left half is sorted
            int leftMin = num[start];
            int rightMin = minHelper(num, mid , end);
            return leftMin < rightMin? leftMin : rightMin;
        } else {
            int rightMin = num[mid];
            int leftMin = minHelper(num, start, mid);
            return leftMin < rightMin? leftMin : rightMin;
        }
    }
}
