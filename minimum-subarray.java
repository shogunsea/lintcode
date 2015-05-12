public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null) {
            return 0;
        }
        
        int min = nums.get(0);
        int previousSum = min;
        int size = nums.size();
    
        for (int i = 1; i < size; i++) {
            int current = nums.get(i);
            previousSum = Math.min(current, current + previousSum);
            min = min > previousSum? previousSum : min;
        }
        
        return min;
    }
}

